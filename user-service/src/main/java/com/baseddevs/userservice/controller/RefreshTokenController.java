package com.baseddevs.userservice.controller;

import com.baseddevs.userservice.dto.auth.AuthenticationResponseDTO;
import com.baseddevs.userservice.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
