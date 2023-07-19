package com.baseddevs.userservice.repository;

import com.baseddevs.userservice.model.User;
import com.baseddevs.userservice.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findAllByUser(User user);
}