package com.baseddevs.userservice.service;

import com.baseddevs.userservice.dto.auth.AuthenticationResponseDTO;
import com.baseddevs.userservice.dto.auth.ConfirmedAccountResponseDTO;
import com.baseddevs.userservice.dto.auth.LoginRequest;

public interface AuthService {

    AuthenticationResponseDTO authenticate(LoginRequest loginDTO);

    ConfirmedAccountResponseDTO confirmUserAccount(String confirmationToken);
}
