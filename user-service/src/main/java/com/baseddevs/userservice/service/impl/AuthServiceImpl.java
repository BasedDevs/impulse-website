package com.baseddevs.userservice.service.impl;

import com.baseddevs.userservice.dto.auth.AuthenticationResponseDTO;
import com.baseddevs.userservice.dto.auth.ConfirmedAccountResponseDTO;
import com.baseddevs.userservice.dto.auth.LoginRequest;
import com.baseddevs.userservice.exception.NoUserWithConfirmationTokenException;
import com.baseddevs.userservice.model.RefreshToken;
import com.baseddevs.userservice.model.User;
import com.baseddevs.userservice.repository.RefreshTokenRepository;
import com.baseddevs.userservice.repository.UserRepository;
import com.baseddevs.userservice.security.model.SecurityUser;
import com.baseddevs.userservice.security.utils.JwtUtils;
import com.baseddevs.userservice.service.AuthService;
import com.baseddevs.userservice.service.RefreshTokenService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    private final UserRepository userRepository;

    private final RefreshTokenService refreshTokenService;

    @Override
    public AuthenticationResponseDTO authenticate(LoginRequest loginDTO) {
        Authentication auth = authenticate(loginDTO.username(), loginDTO.password());
        String jwt = jwtUtils.generateJwtToken(auth);

        RefreshToken newRefreshToken = refreshTokenService.createRefreshToken(((SecurityUser) auth.getPrincipal()).getUser());
        return new AuthenticationResponseDTO(jwt, newRefreshToken.getToken());
    }

    @Override
    public ConfirmedAccountResponseDTO confirmUserAccount(String confirmationToken) {
        User user = userRepository.findByConfirmationToken(confirmationToken).orElseThrow(() ->
                new NoUserWithConfirmationTokenException("Couldn't find a user with that confirmation token"));

        user.setEmailVerified(true);
        userRepository.save(user);

        return new ConfirmedAccountResponseDTO("Account verified");

    }

    private Authentication authenticate(@NotNull @NotBlank String username, @NotNull @NotBlank String password) {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            throw new BadCredentialsException("Wrong username or password.", e);
        }
    }


}
