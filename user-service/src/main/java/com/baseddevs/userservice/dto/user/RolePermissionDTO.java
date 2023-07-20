package com.baseddevs.userservice.dto.user;

import com.baseddevs.userservice.dto.permission.PermissionDTO;
import com.baseddevs.userservice.dto.role.RoleDTO;

public record RolePermissionDTO(Long id, RoleDTO roleDTO, PermissionDTO permissionDTO) {

}