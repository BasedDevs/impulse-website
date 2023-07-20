package com.baseddevs.userservice.service.impl;

import com.baseddevs.userservice.model.User;
import com.baseddevs.userservice.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendConfirmationEmail(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Welcome to IMPULSE BABYYYYY");
        message.setText("Thank you for signing up, " + user.getUsername() + ". Please click the link below to verify your email address: \n"
                + "http://localhost:8081/auth/confirm-account?token=" + user.getConfirmationToken());

        mailSender.send(message);
    }

    @Override
    public void sendPasswordResetEmail(String email, String passwordResetToken, String username) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Reset");
        message.setText("Hello, " + username + ". A password reset has been requested. If you requested it please proceed with the following link: \n"
                + "http://localhost:8081/auth/password/reset?token=" + passwordResetToken);

        mailSender.send(message);
    }
}