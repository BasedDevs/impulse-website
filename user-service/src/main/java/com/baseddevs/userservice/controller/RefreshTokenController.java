package com.baseddevs.userservice.controller;

import com.baseddevs.userservice.dto.auth.AuthenticationResponseDTO;
import com.baseddevs.userservice.dto.auth.ConfirmedAccountResponseDTO;
import com.baseddevs.userservice.dto.auth.LoginRequest;
import com.baseddevs.userservice.model.RefreshToken;
import com.baseddevs.userservice.service.AuthService;
import com.baseddevs.userservice.service.RefreshTokenService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Optional;

@RestController
@RequestMapping("/api/refreshToken")
@AllArgsConstructor
public class RefreshTokenController {

    private final RefreshTokenService refreshTokenService;

    @PostMapping
    public ResponseEntity<AuthenticationResponseDTO> refreshToken(@RequestParam String refreshToken) {
        AuthenticationResponseDTO responseDTO = refreshTokenService.refreshToken(refreshToken);
        return ResponseEntity.ok(responseDTO);
    }

}
