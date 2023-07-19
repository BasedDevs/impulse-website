package com.baseddevs.userservice.service.impl;

import com.baseddevs.userservice.dto.auth.AuthenticationResponseDTO;
import com.baseddevs.userservice.model.RefreshToken;
import com.baseddevs.userservice.model.User;
import com.baseddevs.userservice.repository.RefreshTokenRepository;
import com.baseddevs.userservice.security.utils.JwtUtils;
import com.baseddevs.userservice.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtUtils jwtUtils;

    @Override
    public RefreshToken createRefreshToken(User user) {
        String refreshToken = UUID.randomUUID().toString(); // Simple token generation, consider using a more secure method

        RefreshToken newRefreshToken = new RefreshToken();
        newRefreshToken.setToken(refreshToken);
        newRefreshToken.setUser(user);
        newRefreshToken.setExpiryDate(Instant.now().plus(7, ChronoUnit.DAYS)); // Token valid for 7 days, adjust as needed

        return refreshTokenRepository.save(newRefreshToken);
    }

    @Override
    public AuthenticationResponseDTO refreshToken(String refreshToken) {
        RefreshToken token = refreshTokenRepository.findByToken(refreshToken).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid refresh token"));

        if (token.getExpiryDate().isAfter(Instant.now())) {
            Authentication auth = new UsernamePasswordAuthenticationToken(token.getUser().getUsername(), null, new ArrayList<>());
            String jwt = jwtUtils.generateJwtToken(auth);
            return new AuthenticationResponseDTO(jwt, refreshToken); // Optionally generate a new refresh token here
        } else {
            refreshTokenRepository.delete(token);
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Refresh token expired");
        }
    }
}
