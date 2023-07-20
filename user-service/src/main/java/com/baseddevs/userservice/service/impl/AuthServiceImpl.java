package com.baseddevs.userservice.service.impl;

import com.baseddevs.userservice.dto.auth.ConfirmedAccountResponseDTO;
import com.baseddevs.userservice.exception.NoUserWithConfirmationTokenException;
import com.baseddevs.userservice.model.User;
import com.baseddevs.userservice.repository.UserRepository;
import com.baseddevs.userservice.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public ConfirmedAccountResponseDTO confirmUserAccount(String confirmationToken) {
        User user = userRepository.findByConfirmationToken(confirmationToken).orElseThrow(() ->
                new NoUserWithConfirmationTokenException("Couldn't find a user with that confirmation token"));

        user.setEmailVerified(true);
        userRepository.save(user);

        return new ConfirmedAccountResponseDTO("Account verified");

    }

}
