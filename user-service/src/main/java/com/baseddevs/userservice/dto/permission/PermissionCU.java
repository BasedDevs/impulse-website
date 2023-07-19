package com.baseddevs.userservice.dto.permission;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PermissionCU(
        @NotBlank(message = "Permission name cannot be blank/null")
        @Size(min = 1, max = 100, message = "Permission name must be between 1 and 100 characters")
        String name
) {
}