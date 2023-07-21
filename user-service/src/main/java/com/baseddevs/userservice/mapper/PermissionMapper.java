package com.baseddevs.userservice.mapper;

import com.baseddevs.userservice.dto.permission.PermissionDTO;
import com.baseddevs.userservice.model.Permission;
import org.springframework.stereotype.Service;

@Service
public class PermissionMapper {

    public PermissionDTO toDTO(Permission permission) {
        return new PermissionDTO(permission.getId(), permission.getName());
    }

    public Permission toEntity(PermissionDTO dto) {
        Permission permission = new Permission();
        permission.setId(dto.getId());
        permission.setName(dto.getName());

        return permission;
    }

}
