package com.baseddevs.userservice.service.impl;

import com.baseddevs.userservice.dto.role.RoleDTO;
import com.baseddevs.userservice.dto.user.UserCU;
import com.baseddevs.userservice.dto.user.UserDTO;
import com.baseddevs.userservice.dto.user.UserRoleDTO;
import com.baseddevs.userservice.dto.user.UserUpdatePasswordDTO;
import com.baseddevs.userservice.exception.utils.ExceptionUtils;
import com.baseddevs.userservice.mapper.UserMapper;
import com.baseddevs.userservice.mapper.UserRoleMapper;
import com.baseddevs.userservice.model.Role;
import com.baseddevs.userservice.model.User;
import com.baseddevs.userservice.model.UserRole;
import com.baseddevs.userservice.repository.RoleRepository;
import com.baseddevs.userservice.repository.UserRepository;
import com.baseddevs.userservice.repository.UserRoleRepository;
import com.baseddevs.userservice.service.EmailService;
import com.baseddevs.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    private final UserMapper userMapper;

    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;
    private final UserRoleMapper userRoleMapper;

    private final ExceptionUtils exceptionUtils;

    @Override
    public UserDTO createUser(UserCU userCU) {
        // Check if the username is already taken
        if (userRepository.existsByUsername(userCU.getUsername())) {
            throw exceptionUtils.createResourceAlreadyExistsException("User", "username", userCU.getUsername());
        }
        // Check if the email is already used
        if (userRepository.existsByEmail(userCU.getEmail())) {
            throw exceptionUtils.createResourceAlreadyExistsException("User", "email", userCU.getEmail());
        }
        // Create new User entity
        User user = new User();
        // Hash the password
        user.setPassword(passwordEncoder.encode(userCU.getPassword()));

        // Set user-sent data
        user.setEmail(userCU.getEmail());
        user.setUsername(userCU.getUsername());
        user.setFirstName(userCU.getFirstName());
        user.setLastName(userCU.getLastName());

        // Generate a confirmation token
        user.setConfirmationToken(UUID.randomUUID().toString());

        User savedUser = userRepository.save(user);
        Set<UserRole> userRoles = getUserRoles(savedUser, userCU.getRoles());
        savedUser.setUserRoles(userRoles);

        // Send a confirmation email
        emailService.sendConfirmationEmail(savedUser);

        return userMapper.toDTO(savedUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userMapper.toDTO(userRepository.findById(id).orElseThrow(() ->
                exceptionUtils.createResourceNotFoundException("User", "id", id.toString())
        ));
    }

    @Override
    public UserDTO updateUser(Long id, UserCU userCU) {
        User user = userRepository.findById(id).orElseThrow(() ->
                exceptionUtils.createResourceNotFoundException("User", "id", id.toString())
        );

        user.setUsername(userCU.getUsername());
        user.setFirstName(userCU.getFirstName());
        user.setLastName(userCU.getLastName());
        user.setEmail(userCU.getEmail());

        User updatedUser = userRepository.save(user);

        return userMapper.toDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO findByUsername(String username) {
        return userMapper.toDTO(userRepository.findByUsername(username).orElseThrow(() ->
                exceptionUtils.createResourceNotFoundException("User", "username", username)
        ));
    }

    @Override
    public List<UserRoleDTO> getUserRolesByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                exceptionUtils.createResourceNotFoundException("User", "username", username)
        );
        return userRoleRepository.findAllByUser(user).stream().map(userRoleMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return userMapper.toDTO(userRepository.findByEmail(email).orElseThrow(() ->
                exceptionUtils.createResourceNotFoundException("User", "email", email)
        ));
    }

    @Override
    public void updateUser(UserUpdatePasswordDTO userUpdatePasswordDTO) {
        User user = userRepository.findById(userUpdatePasswordDTO.getId()).orElseThrow(() ->
                exceptionUtils.createResourceNotFoundException("User", "id", userUpdatePasswordDTO.getId().toString())
        );

        user.setPassword(passwordEncoder.encode(userUpdatePasswordDTO.getNewPassword()));
        userRepository.save(user);
    }

    private Set<UserRole> getUserRoles(User user, Set<RoleDTO> roles) {
        Set<UserRole> userRoles;
        userRoles = roles.stream().map(roleDTO -> {
                    Role role = roleRepository.findByName(roleDTO.getName()).orElseThrow();
                    UserRole userRole = new UserRole();
                    userRole.setUser(user);
                    userRole.setRole(role);
                    userRoleRepository.save(userRole);
                    return userRole;
                }
        ).collect(Collectors.toSet());
        userRoles = new HashSet<>(userRoleRepository.saveAll(userRoles));
        return userRoles;
    }

}