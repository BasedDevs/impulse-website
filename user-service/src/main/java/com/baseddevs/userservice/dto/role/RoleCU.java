package com.baseddevs.userservice.dto.role;

import com.baseddevs.userservice.dto.permission.PermissionDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleCU {
    @NotBlank(message = "Role name cannot be blank/null")
    @Size(min = 1, max = 100, message = "Role name must be between 1 and 100 characters")
    private String name;
    private Set<PermissionDTO> permissions;
}
