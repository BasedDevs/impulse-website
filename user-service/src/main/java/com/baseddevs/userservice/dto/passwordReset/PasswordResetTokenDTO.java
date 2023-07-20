package com.baseddevs.userservice.dto.passwordReset;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordResetTokenDTO {
    private String token;
    private Instant expiryDate;
    private String username;
}
