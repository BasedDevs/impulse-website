package com.baseddevs.userservice.dto.user;

import com.baseddevs.userservice.dto.role.RoleDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Set;

public record UserCU(
        @NotBlank(message = "Username cannot be blank/null")
        @Size(min = 1, max = 50, message = "Username must be between 1 and 50 characters")
        String username,
        @NotBlank(message = "Email cannot be blank/null")
        @Email(message = "Email should be valid")
        String email,
        @NotBlank(message = "Password cannot be blank/null")
        @Size(min = 1, max = 200, message = "Password must be between 1 and 200 characters")
        String password,
        @NotBlank(message = "First Name cannot be blank/null")
        @Size(max = 50, message = "First name must be maximum 50 characters")
        String firstName,
        @NotBlank(message = "Last Name cannot be blank/null")
        @Size(max = 50, message = "Last name must be maximum 50 characters")
        String lastName,
        Set<RoleDTO> roles
) {
}