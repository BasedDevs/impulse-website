package com.baseddevs.userservice.controller;

import com.baseddevs.userservice.dto.auth.ConfirmedAccountResponseDTO;
import com.baseddevs.userservice.dto.permission.PermissionCU;
import com.baseddevs.userservice.dto.permission.PermissionDTO;
import com.baseddevs.userservice.exception.dto.ApiResponse;
import com.baseddevs.userservice.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/permissions")
@AllArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<ApiResponse<PermissionDTO>> createPermission(@RequestBody PermissionCU permissionCU) {
        PermissionDTO permissionDTO = permissionService.createPermission(permissionCU);
        ApiResponse<PermissionDTO> response = new ApiResponse<>(ZonedDateTime.now(), "success", permissionDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PermissionDTO>>> getAllPermissions() {
        List<PermissionDTO> permissions = permissionService.getAllPermissions();
        ApiResponse<List<PermissionDTO>> response = new ApiResponse<>(ZonedDateTime.now(), "success", permissions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PermissionDTO>> getPermissionById(@PathVariable Long id) {
        PermissionDTO permissionDTO = permissionService.getPermissionById(id);
        ApiResponse<PermissionDTO> response = new ApiResponse<>(ZonedDateTime.now(), "success", permissionDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PermissionDTO>> updatePermission(@PathVariable Long id, @RequestBody PermissionCU permissionCU) {
        PermissionDTO updatedPermissionDTO = permissionService.updatePermission(id, permissionCU);
        ApiResponse<PermissionDTO> response = new ApiResponse<>(ZonedDateTime.now(), "success", updatedPermissionDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deletePermission(@PathVariable Long id) {
        permissionService.deletePermission(id);
        ApiResponse<String> response = new ApiResponse<>(ZonedDateTime.now(), "success", "Permission deleted");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
