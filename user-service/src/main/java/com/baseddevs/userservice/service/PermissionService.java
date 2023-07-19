package com.baseddevs.userservice.service;

import com.baseddevs.userservice.dto.permission.PermissionCU;
import com.baseddevs.userservice.dto.permission.PermissionDTO;

import java.util.List;

public interface PermissionService {

    PermissionDTO createPermission(PermissionCU permissionCU);

    List<PermissionDTO> getAllPermissions();

    PermissionDTO getPermissionById(Long id);

    PermissionDTO updatePermission(Long id, PermissionCU permissionCU);

    void deletePermission(Long id);

}
