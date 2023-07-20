package com.baseddevs.userservice.service;

import com.baseddevs.userservice.dto.passwordReset.NewPasswordRequest;
import com.baseddevs.userservice.dto.passwordReset.PasswordResetResponse;
import com.baseddevs.userservice.dto.user.UserDTO;

public interface PasswordResetService {

    UserDTO resetPassword(NewPasswordRequest newPasswordRequest);

    void passwordResetRequest(String email);

    PasswordResetResponse confirmPasswordResetRequest(String resetToken);
}
