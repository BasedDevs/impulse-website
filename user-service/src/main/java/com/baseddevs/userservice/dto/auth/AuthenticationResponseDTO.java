package com.baseddevs.userservice.dto.auth;

public record AuthenticationResponseDTO(
        String jwt,
        String refreshToken
) {

}
