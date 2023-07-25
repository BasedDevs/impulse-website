package com.baseddevs.userservice.dto.user;

import com.baseddevs.userservice.dto.role.RoleDTO;
import com.baseddevs.userservice.model.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCU {
    @NotBlank(message = "Username cannot be blank/null")
    @Size(min = 1, max = 50, message = "Username must be between 1 and 50 characters")
    private String username;

    @NotBlank(message = "Email cannot be blank/null")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password cannot be blank/null")
    @Size(min = 1, max = 200, message = "Password must be between 1 and 200 characters")
    private String password;

    @NotBlank(message = "First Name cannot be blank/null")
    @Size(max = 50, message = "First name must be maximum 50 characters")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank/null")
    @Size(max = 50, message = "Last name must be maximum 50 characters")
    private String lastName;

    private Set<RoleDTO> roles;

    private Set<AddressDTO> addresses;
}