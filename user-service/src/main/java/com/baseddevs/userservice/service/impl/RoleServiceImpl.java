package com.baseddevs.userservice.service.impl;

import com.baseddevs.userservice.dto.role.RoleCU;
import com.baseddevs.userservice.dto.role.RoleDTO;
import com.baseddevs.userservice.exception.RoleAlreadyExistsException;
import com.baseddevs.userservice.exception.RoleNotFoundException;
import com.baseddevs.userservice.mapper.RoleMapper;
import com.baseddevs.userservice.model.Role;
import com.baseddevs.userservice.repository.RoleRepository;
import com.baseddevs.userservice.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleDTO createRole(RoleCU roleCU) {

        if (roleRepository.existsByName(roleCU.getName())) {
            throw new RoleAlreadyExistsException("Role " + roleCU.getName() + " already exists");
        }

        Role role = new Role();
        role.setName(roleCU.getName());
        role = roleRepository.save(role);

        return roleMapper.toDTO(role);
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream()
                .map(roleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role with id " + id + " not found"));
        return roleMapper.toDTO(role);
    }

    @Override
    public RoleDTO updateRole(Long id, RoleCU roleCU) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role with id " + id + " not found"));
        role.setName(roleCU.getName());
        Role updatedRole = roleRepository.save(role);
        return roleMapper.toDTO(updatedRole);
    }

    @Override
    public void deleteRole(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role with id " + id + " not found"));
        roleRepository.delete(role);
    }
}