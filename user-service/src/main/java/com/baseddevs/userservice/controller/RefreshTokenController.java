package com.baseddevs.userservice.controller;

import com.baseddevs.userservice.dto.auth.AuthenticationResponseDTO;
import com.baseddevs.userservice.dto.permission.PermissionDTO;
import com.baseddevs.userservice.exception.dto.ApiResponse;
import com.baseddevs.userservice.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/api/refreshToken")
@AllArgsConstructor
public class RefreshTokenController {

    private final RefreshTokenService refreshTokenService;

    @PostMapping
    public ResponseEntity<ApiResponse<AuthenticationResponseDTO>> refreshToken(@RequestParam String refreshToken) {
        AuthenticationResponseDTO responseDTO = refreshTokenService.refreshToken(refreshToken);
        ApiResponse<AuthenticationResponseDTO> response = new ApiResponse<>(ZonedDateTime.now(), "success", responseDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
