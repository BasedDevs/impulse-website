package com.baseddevs.userservice.service.impl;

import com.baseddevs.userservice.dto.role.RoleDTO;
import com.baseddevs.userservice.dto.user.UserCU;
import com.baseddevs.userservice.dto.user.UserDTO;
import com.baseddevs.userservice.dto.user.UserRoleDTO;
import com.baseddevs.userservice.dto.user.UserUpdatePasswordDTO;
import com.baseddevs.userservice.exception.EmailAlreadyUsedException;
import com.baseddevs.userservice.exception.UserNotFoundException;
import com.baseddevs.userservice.exception.UsernameAlreadyTakenException;
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

    @Override
    public UserDTO createUser(UserCU userCU) {
        // Check if the username is already taken
        if (userRepository.existsByUsername(userCU.username())) {
            throw new UsernameAlreadyTakenException("The username " + userCU.username() + " is already taken");
        }
        // Check if the email is already used
        if (userRepository.existsByEmail(userCU.email())) {
            throw new EmailAlreadyUsedException("The email " + userCU.email() + " is already used");
        }
        // Create new User entity
        User user = new User();
        // Hash the password
        user.setPassword(passwordEncoder.encode(userCU.password()));

        // Set user-sent data
        user.setEmail(userCU.email());
        user.setUsername(userCU.username());
        user.setFirstName(userCU.firstName());
        user.setLastName(userCU.lastName());

        // Generate a confirmation token
        user.setConfirmationToken(UUID.randomUUID().toString());

        User savedUser = userRepository.save(user);
        Set<UserRole> userRoles = getUserRoles(savedUser, userCU.roles());
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
                new UserNotFoundException("User with id " + id + " not found")
        ));
    }

    @Override
    public UserDTO updateUser(Long id, UserCU userCU) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id" + id + " not found"));

        user.setUsername(userCU.username());
        user.setFirstName(userCU.firstName());
        user.setLastName(userCU.lastName());
        user.setEmail(userCU.email());

        // Handle password and roles update logic as well
        // ...

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
                new UserNotFoundException("User with username " + username + " not found")));
    }

    @Override
    public List<UserRoleDTO> getUserRolesByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UserNotFoundException("User with username " + username + " not found"));
        return userRoleRepository.findAllByUser(user).stream().map(userRoleMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return userMapper.toDTO(userRepository.findByEmail(email).orElseThrow(() ->
                new UserNotFoundException("User with email " + email + " not found")));
    }

    @Override
    public void updateUser(UserUpdatePasswordDTO userUpdatePasswordDTO) {
        User user = userRepository.findById(userUpdatePasswordDTO.id()).orElseThrow(() ->
                new UserNotFoundException("User with id " + userUpdatePasswordDTO.id() + " not found"));

        user.setPassword(passwordEncoder.encode(userUpdatePasswordDTO.newPassword()));
        userRepository.save(user);
    }

    private Set<UserRole> getUserRoles(User user, Set<RoleDTO> roles) {
        Set<UserRole> userRoles;
        userRoles = roles.stream().map(roleDTO -> {
                    Role role = roleRepository.findByName(roleDTO.name()).orElseThrow();
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