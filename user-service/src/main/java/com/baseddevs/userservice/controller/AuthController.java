package com.baseddevs.userservice.controller;

import com.baseddevs.userservice.dto.auth.*;
import com.baseddevs.userservice.dto.passwordReset.NewPasswordRequest;
import com.baseddevs.userservice.dto.passwordReset.PasswordResetRequest;
import com.baseddevs.userservice.dto.passwordReset.PasswordResetResponse;
import com.baseddevs.userservice.service.AuthService;
import com.baseddevs.userservice.service.PasswordResetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final PasswordResetService passwordResetService;

    @GetMapping("/confirm-account")
    public ResponseEntity<ConfirmedAccountResponseDTO> confirmUserAccount(@RequestParam("token") String confirmationToken) {
        return new ResponseEntity<>(authService.confirmUserAccount(confirmationToken), HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LogoutRequest logoutRequest) {
        authService.logout(logoutRequest.getRefreshToken());
        return ResponseEntity.ok("Logout Successful");
    }

    @PostMapping("/password/reset/request")
    public ResponseEntity<?> requestPasswordReset(@RequestBody PasswordResetRequest passwordResetRequest) {
        passwordResetService.passwordResetRequest(passwordResetRequest.getEmail());
        return ResponseEntity.ok("Password reset request sent!");
    }

    @GetMapping("/password/reset")
    public ResponseEntity<PasswordResetResponse> showPasswordResetForm(@RequestParam("token") String resetToken) {
        return new ResponseEntity<>(passwordResetService.confirmPasswordResetRequest(resetToken), HttpStatus.OK);
    }

    @PutMapping("/password/reset")
    public ResponseEntity<?> resetPassword(@RequestBody NewPasswordRequest newPasswordRequest) {
        return new ResponseEntity<>(passwordResetService.resetPassword(newPasswordRequest), HttpStatus.OK);
    }

}
