package com.baseddevs.userservice.dto.user;

import com.baseddevs.userservice.dto.role.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDTO {
    private Long id;
    private Long userId;
    private RoleDTO roleDTO;
}
