package com.baseddevs.userservice.service.impl;

import com.baseddevs.userservice.dto.passwordReset.NewPasswordRequest;
import com.baseddevs.userservice.dto.passwordReset.PasswordResetResponse;
import com.baseddevs.userservice.dto.user.UserDTO;
import com.baseddevs.userservice.dto.user.UserUpdatePasswordDTO;
import com.baseddevs.userservice.exception.TokenExpiredException;
import com.baseddevs.userservice.exception.TokenNotFoundException;
import com.baseddevs.userservice.mapper.UserMapper;
import com.baseddevs.userservice.model.PasswordResetToken;
import com.baseddevs.userservice.model.User;
import com.baseddevs.userservice.repository.PasswordResetTokenRepository;
import com.baseddevs.userservice.service.EmailService;
import com.baseddevs.userservice.service.PasswordResetService;
import com.baseddevs.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class PasswordResetServiceImpl implements PasswordResetService {

    @Value("${passwordResetMs}")
    private Long passwordResetMs;

    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final UserService userService;
    private final UserMapper userMapper;
    private final EmailService emailService;

    public PasswordResetServiceImpl(PasswordResetTokenRepository passwordResetTokenRepository, UserService userService, UserMapper userMapper, EmailService emailService) {
        this.passwordResetTokenRepository = passwordResetTokenRepository;
        this.userService = userService;
        this.userMapper = userMapper;
        this.emailService = emailService;
    }

    public UserDTO resetPassword(NewPasswordRequest newPasswordRequest) {
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(newPasswordRequest.getToken())
                .orElseThrow(() -> new TokenNotFoundException("Token Not Found for token: " + newPasswordRequest.getToken()));

        if (hasExpired(passwordResetToken)) {
            throw new TokenExpiredException("Token Expired");
        }

        User user = passwordResetToken.getUser();
        UserUpdatePasswordDTO userUpdatePasswordDTO = new UserUpdatePasswordDTO(user.getId(), newPasswordRequest.getNewPassword());
        userService.updateUser(userUpdatePasswordDTO);

        // Invalidate the reset token
        delete(passwordResetToken);
        return userMapper.toDTO(user);
    }

    private boolean hasExpired(PasswordResetToken passwordResetToken) {
        return passwordResetToken.getExpiryDate().isBefore(Instant.now());
    }

    private void delete(PasswordResetToken passwordResetToken) {
        passwordResetTokenRepository.delete(passwordResetToken);
    }

    @Override
    public void passwordResetRequest(String email) {
        UserDTO userDTO = userService.getUserByEmail(email);
        User userEntity = userMapper.toEntity(userDTO);

        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setUser(userEntity);
        Instant now = Instant.now();
        Instant expiryDate = now.plusMillis(passwordResetMs);
        passwordResetToken.setExpiryDate(expiryDate);
        passwordResetToken.setToken(UUID.randomUUID().toString());

        passwordResetTokenRepository.save(passwordResetToken);

        emailService.sendPasswordResetEmail(email, passwordResetToken.getToken(), userDTO.getUsername());
    }

    @Override
    public PasswordResetResponse confirmPasswordResetRequest(String resetToken) {
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(resetToken)
                .orElseThrow(() -> new TokenNotFoundException("Token Not Found for token: " + resetToken));

        if (hasExpired(passwordResetToken)) {
            throw new TokenExpiredException("Token Expired");
        }

        return new PasswordResetResponse("Token Confirmed. Show password reset form.");
    }
}
