package com.baseddevs.userservice.dto.auth;

public record PasswordResetRequest(
        String token,
        String newPassword
) {

}
