package com.baseddevs.userservice.dto.passwordReset;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewPasswordRequest {
    private String token;
    private String newPassword;
}
