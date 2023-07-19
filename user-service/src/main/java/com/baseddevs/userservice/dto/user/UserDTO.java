package com.baseddevs.userservice.dto.user;

import com.baseddevs.userservice.dto.role.RoleDTO;

import java.util.Set;

public record UserDTO(
        Long id,
        String username,
        String email,
        String firstName,
        String lastName,
        Set<RoleDTO> roles
) {
}