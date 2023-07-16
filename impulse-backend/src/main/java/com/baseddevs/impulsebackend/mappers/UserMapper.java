package com.baseddevs.impulsebackend.mappers;

import com.baseddevs.impulsebackend.dto.UserDTO;
import com.baseddevs.impulsebackend.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getHashedPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getRegistrationDate(),
                user.getLastLoginDate()
        );
    }
}