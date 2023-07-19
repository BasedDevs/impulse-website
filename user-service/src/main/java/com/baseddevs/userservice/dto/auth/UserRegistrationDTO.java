package com.baseddevs.userservice.dto.auth;

public record UserRegistrationDTO(
        String username,
        String email,
        String password,
        String firstName,
        String lastName
) {

}