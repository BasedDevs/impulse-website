package com.baseddevs.impulsebackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;

public record UserUpdateDTO(
        @NotBlank(message = "Username cannot be blank/null")
        @Size(min = 1, max = 50, message = "Username must be between 1 and 50 characters") String username,
        @NotBlank(message = "Email cannot be blank/null")
        @Email(message = "Email should be valid") String email,
        @NotBlank(message = "Hashed password cannot be blank/null")
        @Size(min = 1, max = 200, message = "Hashed password must be between 1 and 200 characters") String hashedPassword,
        @NotBlank(message = "First Name cannot be blank/null")
        @Size(max = 50, message = "First name must be maximum 50 characters") String firstName,
        @NotBlank(message = "Last Name cannot be blank/null")
        @Size(max = 50, message = "Last name must be maximum 50 characters") String lastName,
        @NotNull(message = "Registration date cannot be null") Date registrationDate,
        Date lastLoginDate
) {

}