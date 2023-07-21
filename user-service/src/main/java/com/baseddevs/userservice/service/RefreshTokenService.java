package com.baseddevs.userservice.service;

import com.baseddevs.userservice.dto.auth.AuthenticationResponseDTO;
import com.baseddevs.userservice.model.RefreshToken;

public interface RefreshTokenService {

    RefreshToken createRefreshToken(String username);

    AuthenticationResponseDTO refreshToken(String refreshToken);

    void invalidateRefreshToken(String refreshToken);
}
