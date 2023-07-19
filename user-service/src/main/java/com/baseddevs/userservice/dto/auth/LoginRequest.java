package com.baseddevs.userservice.dto.auth;

public record LoginRequest(
        String username,
        String password
) {

}
