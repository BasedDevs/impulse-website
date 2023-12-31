package com.baseddevs.userservice.service;

import com.baseddevs.userservice.model.User;

public interface EmailService {

    void sendConfirmationEmail(User user);

    void sendPasswordResetEmail(String email, String token, String username);
}
