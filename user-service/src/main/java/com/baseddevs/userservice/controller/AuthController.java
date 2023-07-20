package com.baseddevs.userservice.controller;

import com.baseddevs.userservice.dto.auth.ConfirmedAccountResponseDTO;
import com.baseddevs.userservice.dto.auth.PasswordResetRequest;
import com.baseddevs.userservice.dto.auth.PasswordResetResponse;
import com.baseddevs.userservice.dto.auth.PasswordResetTokenDTO;
import com.baseddevs.userservice.dto.user.UserDTO;
import com.baseddevs.userservice.service.AuthService;
import com.baseddevs.userservice.service.PasswordResetService;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String refreshToken = request.getHeader("Refresh-Token");
        // Invalidate the token
        authService.logout(refreshToken);
        return ResponseEntity.ok("Logout Successful");
    }

    @PostMapping("/password/reset/request")
    public ResponseEntity<?> requestPasswordReset(@RequestParam("email") String email) {
        passwordResetService.passwordResetRequest(email);
        return ResponseEntity.ok("Password reset request sent!");
    }

    @GetMapping("/password/reset")
    public ResponseEntity<PasswordResetResponse> showPasswordResetForm(@RequestParam("token") String resetToken) {
        return new ResponseEntity<>(passwordResetService.confirmPasswordResetRequest(resetToken), HttpStatus.OK);
    }

    @PutMapping("/password/reset")
    public ResponseEntity<?> resetPassword(@RequestBody PasswordResetRequest passwordResetRequest) {
        return new ResponseEntity<>(passwordResetService.resetPassword(passwordResetRequest), HttpStatus.OK);
    }

}
