package com.baseddevs.userservice.dto.user;

import com.baseddevs.userservice.dto.permission.PermissionDTO;
import com.baseddevs.userservice.dto.role.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolePermissionDTO {
    private Long id;
    private RoleDTO roleDTO;
    private PermissionDTO permissionDTO;
}