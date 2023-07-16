package com.baseddevs.impulsebackend.service;

import com.baseddevs.impulsebackend.dto.UserCreateDTO;
import com.baseddevs.impulsebackend.dto.UserDTO;
import com.baseddevs.impulsebackend.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long userId);

    UserDTO createUser(UserCreateDTO user);

    UserDTO updateUserById(Long userId, UserUpdateDTO user);

    void deleteUserById(Long userId);
}
