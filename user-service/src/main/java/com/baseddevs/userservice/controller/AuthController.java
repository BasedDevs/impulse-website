package com.baseddevs.userservice.controller;

import com.baseddevs.userservice.dto.auth.ConfirmedAccountResponseDTO;
import com.baseddevs.userservice.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/confirm-account")
    public ResponseEntity<ConfirmedAccountResponseDTO> confirmUserAccount(@RequestParam("token") String confirmationToken) {
        return new ResponseEntity<>(authService.confirmUserAccount(confirmationToken), HttpStatus.OK);
    }

}
