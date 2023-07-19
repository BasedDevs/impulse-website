package com.baseddevs.userservice.dto.role;

import com.baseddevs.userservice.dto.permission.PermissionDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record RoleCU(
        @NotBlank(message = "Role name cannot be blank/null")
        @Size(min = 1, max = 100, message = "Role name must be between 1 and 100 characters")
        String name,
        Set<PermissionDTO> permissions
) {
}
