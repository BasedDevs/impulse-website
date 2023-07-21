package com.baseddevs.userservice.service;

import com.baseddevs.userservice.dto.auth.ConfirmedAccountResponseDTO;

public interface AuthService {

    ConfirmedAccountResponseDTO confirmUserAccount(String confirmationToken);

    void logout(String refreshToken);
}
