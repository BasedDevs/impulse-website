package com.baseddevs.userservice.service;

import com.baseddevs.userservice.dto.role.RoleCU;
import com.baseddevs.userservice.dto.role.RoleDTO;

import java.util.List;

public interface RoleService {

    RoleDTO createRole(RoleCU roleCU);

    List<RoleDTO> getAllRoles();

    RoleDTO getRoleById(Long id);

    RoleDTO updateRole(Long id, RoleCU roleCU);

    void deleteRole(Long id);

}
