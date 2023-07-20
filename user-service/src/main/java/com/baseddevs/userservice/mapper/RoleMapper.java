package com.baseddevs.userservice.mapper;

import com.baseddevs.userservice.dto.permission.PermissionDTO;
import com.baseddevs.userservice.dto.role.RoleDTO;
import com.baseddevs.userservice.dto.user.RolePermissionDTO;
import com.baseddevs.userservice.model.Permission;
import com.baseddevs.userservice.model.Role;
import com.baseddevs.userservice.model.RolePermission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleMapper {

    private final PermissionMapper permissionMapper;

    public RoleDTO toDTO(Role role) {
        Set<PermissionDTO> permissions = role.getRolePermissions().stream()
                .map(rolePermission -> permissionMapper.toDTO(rolePermission.getPermission()))
                .collect(Collectors.toSet());
        return new RoleDTO(role.getId(), role.getName(), permissions);
    }


    public Role toEntity(RoleDTO dto) {
        Role role = new Role();
        role.setId(dto.getId());
        role.setName(dto.getName());

        Set<RolePermission> rolePermissions = dto.getPermissions().stream()
                .map(permissionDTO -> {
                    RolePermission rolePermission = new RolePermission();
                    rolePermission.setRole(role);
                    rolePermission.setPermission(permissionMapper.toEntity(permissionDTO));
                    return rolePermission;
                })
                .collect(Collectors.toSet());

        role.setRolePermissions(rolePermissions);

        return role;
    }
}
