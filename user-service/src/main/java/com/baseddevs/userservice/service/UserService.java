package com.baseddevs.userservice.service;

import com.baseddevs.userservice.dto.user.UserCU;
import com.baseddevs.userservice.dto.user.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserCU userCU);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO updateUser(Long id, UserCU userCU);

    void deleteUser(Long id);

}
