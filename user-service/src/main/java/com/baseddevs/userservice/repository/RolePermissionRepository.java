package com.baseddevs.userservice.repository;

import com.baseddevs.userservice.model.Role;
import com.baseddevs.userservice.model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
    List<RolePermission> findAllByRole(Role role);
}