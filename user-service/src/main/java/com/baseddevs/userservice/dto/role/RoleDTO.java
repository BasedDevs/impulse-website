package com.baseddevs.userservice.dto.role;

import com.baseddevs.userservice.dto.permission.PermissionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private Long id;
    private String name;
    private Set<PermissionDTO> permissions;
}