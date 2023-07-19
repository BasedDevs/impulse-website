package com.baseddevs.userservice.service;

import com.baseddevs.userservice.dto.auth.AuthenticationResponseDTO;
import com.baseddevs.userservice.dto.auth.ConfirmedAccountResponseDTO;
import com.baseddevs.userservice.dto.auth.LoginRequest;
import com.baseddevs.userservice.model.RefreshToken;
import com.baseddevs.userservice.model.User;

public interface RefreshTokenService {

    RefreshToken createRefreshToken(User user);

    AuthenticationResponseDTO refreshToken(String refreshToken);
}
