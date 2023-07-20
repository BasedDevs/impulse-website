package com.baseddevs.userservice.mapper;

import com.baseddevs.userservice.dto.user.RolePermissionDTO;
import com.baseddevs.userservice.model.Permission;
import com.baseddevs.userservice.model.Role;
import com.baseddevs.userservice.model.RolePermission;

public class RolePermissionMapper {

    public RolePermission toEntity(RolePermissionDTO rolePermissionDTO, Role role, Permission permission) {
        return new RolePermission(rolePermissionDTO.id(), role, permission);
    }

}
