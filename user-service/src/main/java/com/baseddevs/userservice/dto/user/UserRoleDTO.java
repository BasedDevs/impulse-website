package com.baseddevs.userservice.dto.user;

import com.baseddevs.userservice.dto.role.RoleDTO;

public record UserRoleDTO(Long id, Long userId, RoleDTO roleDTO) {

}
