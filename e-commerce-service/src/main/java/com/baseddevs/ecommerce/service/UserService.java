package com.baseddevs.service;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long userId);

    UserDTO createUser(UserCreateDTO user);

    UserDTO updateUserById(Long userId, UserUpdateDTO user);

    void deleteUserById(Long userId);
}
