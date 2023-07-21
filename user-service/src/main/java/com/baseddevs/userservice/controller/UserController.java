package com.baseddevs.userservice.controller;

import com.baseddevs.userservice.dto.user.UserCU;
import com.baseddevs.userservice.dto.user.UserDTO;
import com.baseddevs.userservice.exception.dto.ApiResponse;
import com.baseddevs.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserDTO>> createUser(@RequestBody UserCU userCU) {
        UserDTO userDTO = userService.createUser(userCU);
        ApiResponse<UserDTO> response = new ApiResponse<>(ZonedDateTime.now(), "success", userDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        ApiResponse<List<UserDTO>> response = new ApiResponse<>(ZonedDateTime.now(), "success", users);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        ApiResponse<UserDTO> response = new ApiResponse<>(ZonedDateTime.now(), "success", userDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> updateUser(@PathVariable Long id, @RequestBody UserCU userCU) {
        UserDTO updatedUser = userService.updateUser(id, userCU);
        ApiResponse<UserDTO> response = new ApiResponse<>(ZonedDateTime.now(), "success", updatedUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        ApiResponse<String> response = new ApiResponse<>(ZonedDateTime.now(), "success", "User deleted");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
