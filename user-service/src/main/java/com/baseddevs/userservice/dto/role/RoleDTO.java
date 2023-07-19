package com.baseddevs.userservice.dto.role;

import com.baseddevs.userservice.dto.permission.PermissionDTO;

import java.util.Set;

public record RoleDTO(
        Long id,
        String name,
        Set<PermissionDTO> permissions
) {
}