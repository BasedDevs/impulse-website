package com.baseddevs.impulsebackend.repository;

import com.baseddevs.impulsebackend.model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long>, JpaSpecificationExecutor<RolePermission> {
}