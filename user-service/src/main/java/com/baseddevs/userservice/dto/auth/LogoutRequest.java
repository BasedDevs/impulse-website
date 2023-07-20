package com.baseddevs.userservice.dto.auth;

public record LogoutRequest(
        String username,
        String password
) {

}
