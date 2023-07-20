package com.baseddevs.userservice.service.impl;

import com.baseddevs.userservice.dto.permission.PermissionCU;
import com.baseddevs.userservice.dto.permission.PermissionDTO;
import com.baseddevs.userservice.exception.PermissionNotFoundException;
import com.baseddevs.userservice.exception.RoleAlreadyExistsException;
import com.baseddevs.userservice.mapper.PermissionMapper;
import com.baseddevs.userservice.model.Permission;
import com.baseddevs.userservice.repository.PermissionRepository;
import com.baseddevs.userservice.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    @Override
    public PermissionDTO createPermission(PermissionCU permissionCU) {

        if (permissionRepository.existsByName(permissionCU.getName())) {
            throw new RoleAlreadyExistsException("Permission " + permissionCU.getName() + " already exists");
        }

        Permission permission = new Permission();
        permission.setName(permissionCU.getName());
        permission = permissionRepository.save(permission);

        return permissionMapper.toDTO(permission);
    }

    @Override
    public List<PermissionDTO> getAllPermissions() {
        List<Permission> permissions = permissionRepository.findAll();
        return permissions.stream()
                .map(permissionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PermissionDTO getPermissionById(Long id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new PermissionNotFoundException("Permission with id " + id + " not found"));
        return permissionMapper.toDTO(permission);
    }

    @Override
    public PermissionDTO updatePermission(Long id, PermissionCU permissionCU) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new PermissionNotFoundException("Permission with id " + id + " not found"));
        permission.setName(permissionCU.getName());
        Permission updatedPermission = permissionRepository.save(permission);
        return permissionMapper.toDTO(updatedPermission);
    }

    @Override
    public void deletePermission(Long id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new PermissionNotFoundException("Permission with id " + id + " not found"));
        permissionRepository.delete(permission);
    }
}