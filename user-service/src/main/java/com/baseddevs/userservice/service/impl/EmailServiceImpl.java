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
                + "http://localhost:8081/api/auth/confirm-account?token=" + user.getConfirmationToken());

        mailSender.send(message);
    }
}