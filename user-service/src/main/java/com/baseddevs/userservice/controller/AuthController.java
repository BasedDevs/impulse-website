package com.baseddevs.userservice.controller;

import com.baseddevs.userservice.dto.auth.*;
import com.baseddevs.userservice.dto.passwordReset.NewPasswordRequest;
import com.baseddevs.userservice.dto.passwordReset.PasswordResetRequest;
import com.baseddevs.userservice.dto.passwordReset.PasswordResetResponse;
import com.baseddevs.userservice.dto.user.UserDTO;
import com.baseddevs.userservice.exception.dto.ApiResponse;
import com.baseddevs.userservice.service.AuthService;
import com.baseddevs.userservice.service.PasswordResetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final PasswordResetService passwordResetService;

    @GetMapping("/confirm-account")
    public ResponseEntity<ApiResponse<ConfirmedAccountResponseDTO>> confirmUserAccount(@RequestParam("token") String confirmationToken) {
        ConfirmedAccountResponseDTO res = authService.confirmUserAccount(confirmationToken);
        ApiResponse<ConfirmedAccountResponseDTO> response = new ApiResponse<>(ZonedDateTime.now(), "success", res);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<String>> logout(@RequestBody LogoutRequest logoutRequest) {
        authService.logout(logoutRequest.getRefreshToken());
        ApiResponse<String> response = new ApiResponse<>(ZonedDateTime.now(), "success", "Logout successful");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/password/reset/request")
    public ResponseEntity<ApiResponse<String>> requestPasswordReset(@RequestBody PasswordResetRequest passwordResetRequest) {
        passwordResetService.passwordResetRequest(passwordResetRequest.getEmail());
        ApiResponse<String> response = new ApiResponse<>(ZonedDateTime.now(), "success", "Password reset request sent");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/password/reset")
    public ResponseEntity<ApiResponse<PasswordResetResponse>> showPasswordResetForm(@RequestParam("token") String resetToken) {
        PasswordResetResponse res = passwordResetService.confirmPasswordResetRequest(resetToken);
        ApiResponse<PasswordResetResponse> response = new ApiResponse<>(ZonedDateTime.now(), "success", res);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/password/reset")
    public ResponseEntity<ApiResponse<UserDTO>> resetPassword(@RequestBody NewPasswordRequest newPasswordRequest) {
        UserDTO res = passwordResetService.resetPassword(newPasswordRequest);
        ApiResponse<UserDTO> response = new ApiResponse<>(ZonedDateTime.now(), "success", res);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
