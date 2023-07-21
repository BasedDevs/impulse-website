package com.baseddevs.userservice.service.impl;

import com.baseddevs.userservice.dto.auth.ConfirmedAccountResponseDTO;
import com.baseddevs.userservice.exception.utils.ExceptionUtils;
import com.baseddevs.userservice.model.User;
import com.baseddevs.userservice.repository.UserRepository;
import com.baseddevs.userservice.service.AuthService;
import com.baseddevs.userservice.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RefreshTokenService refreshTokenService;
    private final ExceptionUtils exceptionUtils;

    @Override
    public ConfirmedAccountResponseDTO confirmUserAccount(String confirmationToken) {
        User user = userRepository.findByConfirmationToken(confirmationToken)
                .orElseThrow(() -> exceptionUtils.createResourceNotFoundException("User", "Confirmation token", confirmationToken)
                );

        user.setEmailVerified(true);
        userRepository.save(user);

        return new ConfirmedAccountResponseDTO("Account verified");
    }

    @Override
    public void logout(String refreshToken) {
        refreshTokenService.invalidateRefreshToken(refreshToken);
    }

}
