package com.baseddevs.userservice.mapper;

import com.baseddevs.userservice.dto.role.RoleDTO;
import com.baseddevs.userservice.dto.user.UserDTO;
import com.baseddevs.userservice.model.User;
import com.baseddevs.userservice.security.dto.UserAuthDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserMapper {

    private final RoleMapper roleMapper;

    public UserDTO toDTO(User user) {
        Set<RoleDTO> roles = user.getUserRoles().stream()
                .map(userRole -> roleMapper.toDTO(userRole.getRole()))
                .collect(Collectors.toSet());
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getFirstName(), user.getLastName(), roles);
    }

    public UserAuthDetails mapToUserAuthDetails(User user) {
        List<String> roleNames = user.getUserRoles().stream()
                .map(userRole -> userRole.getRole().getName())
                .collect(Collectors.toList());

        return new UserAuthDetails(
                user.getUsername(),
                user.getPassword(),
                user.isAccountNonExpired(),
                user.isAccountNonLocked(),
                user.isCredentialsNonExpired(),
                user.isEnabled(),
                roleNames);
    }
}