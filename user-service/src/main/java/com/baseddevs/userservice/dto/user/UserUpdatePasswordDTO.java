package com.baseddevs.userservice.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdatePasswordDTO {
    private Long id;

    @NotBlank(message = "Password cannot be empty.")
    private String newPassword;
}
