package com.baseddevs.userservice.dto.auth;

import java.time.Instant;

public record PasswordResetTokenDTO(
        String token,
        Instant expiryDate,
        String username
) {

}
