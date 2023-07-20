package com.baseddevs.userservice.mapper;

import com.baseddevs.userservice.dto.role.RoleDTO;
import com.baseddevs.userservice.dto.user.UserDTO;
import com.baseddevs.userservice.dto.user.UserRoleDTO;
import com.baseddevs.userservice.model.Role;
import com.baseddevs.userservice.model.User;
import com.baseddevs.userservice.model.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRoleMapper {

    private final RoleMapper roleMapper;

    public UserRoleDTO toDTO(UserRole userRole) {
        Long userId = userRole.getUser().getId();
        RoleDTO roleDTO = roleMapper.toDTO(userRole.getRole());
        return new UserRoleDTO(userRole.getId(), userId, roleDTO);
    }

    public UserRole toEntity(UserRoleDTO userRoleDTO, User user, Role role) {
        return new UserRole(userRoleDTO.id(), user, role);
    }

}
