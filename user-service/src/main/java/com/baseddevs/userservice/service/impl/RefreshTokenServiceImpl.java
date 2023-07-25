package com.baseddevs.userservice.service.impl;

import com.baseddevs.userservice.dto.auth.AuthenticationResponseDTO;
import com.baseddevs.userservice.dto.user.UserDTO;
import com.baseddevs.userservice.exception.utils.ExceptionUtils;
import com.baseddevs.userservice.mapper.UserMapper;
import com.baseddevs.userservice.model.RefreshToken;
import com.baseddevs.userservice.model.User;
import com.baseddevs.userservice.repository.RefreshTokenRepository;
import com.baseddevs.userservice.security.utils.JwtUtils;
import com.baseddevs.userservice.service.RefreshTokenService;
import com.baseddevs.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtUtils jwtUtils;
    private final ExceptionUtils exceptionUtils;
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public RefreshToken createRefreshToken(String username) {
        String refreshToken = UUID.randomUUID().toString(); // Simple token generation, consider using a more secure method

        UserDTO userDTO = userService.findByUsername(username);
        User user = userMapper.toEntity(userDTO);

        RefreshToken newRefreshToken = new RefreshToken();
        newRefreshToken.setToken(refreshToken);
        newRefreshToken.setUser(user);
        newRefreshToken.setExpiryDate(Instant.now().plus(7, ChronoUnit.DAYS)); // Token valid for 7 days, adjust as needed

        return refreshTokenRepository.save(newRefreshToken);
    }

    @Override
    public AuthenticationResponseDTO refreshToken(String refreshToken) {
        RefreshToken token = refreshTokenRepository.findByToken(refreshToken).orElseThrow(() ->
                exceptionUtils.createResourceNotFoundException("RefreshToken", "token", refreshToken));

        if (token.getExpiryDate().isAfter(Instant.now())) {
            Authentication auth = new UsernamePasswordAuthenticationToken(token.getUser().getUsername(), null, new ArrayList<>());
            String jwt = jwtUtils.generateJwtToken(auth);
            return new AuthenticationResponseDTO(jwt, refreshToken); // Optionally generate a new refresh token here
        } else {
            refreshTokenRepository.delete(token);
            throw exceptionUtils.createTokenExpiredException(refreshToken);
        }
    }

    @Override
    public void invalidateRefreshToken(String token) {
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> exceptionUtils.createResourceNotFoundException("RefreshToken", "token", token));

        refreshTokenRepository.delete(refreshToken);
    }
}
