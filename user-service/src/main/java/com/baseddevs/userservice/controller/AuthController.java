package com.baseddevs.userservice.controller;

import com.baseddevs.userservice.dto.auth.AuthenticationResponseDTO;
import com.baseddevs.userservice.dto.auth.ConfirmedAccountResponseDTO;
import com.baseddevs.userservice.dto.auth.LoginRequest;
import com.baseddevs.userservice.service.AuthService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody @NotNull LoginRequest loginRequest) {
        AuthenticationResponseDTO responseDTO = authService.authenticate(loginRequest);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/confirm-account")
    public ResponseEntity<ConfirmedAccountResponseDTO> confirmUserAccount(@RequestParam("token") String confirmationToken) {
        return new ResponseEntity<>(authService.confirmUserAccount(confirmationToken), HttpStatus.OK);
    }

}
