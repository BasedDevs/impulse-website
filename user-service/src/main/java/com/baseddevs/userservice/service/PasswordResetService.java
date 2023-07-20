package com.baseddevs.userservice.service;

import com.baseddevs.userservice.dto.auth.PasswordResetRequest;
import com.baseddevs.userservice.dto.auth.PasswordResetResponse;
import com.baseddevs.userservice.dto.user.UserDTO;

public interface PasswordResetService {

    UserDTO resetPassword(PasswordResetRequest passwordResetRequest);

    void passwordResetRequest(String email);

    PasswordResetResponse confirmPasswordResetRequest(String resetToken);
}
