package com.baseddevs.userservice.controller;

import com.baseddevs.userservice.dto.role.RoleCU;
import com.baseddevs.userservice.dto.role.RoleDTO;
import com.baseddevs.userservice.exception.dto.ApiResponse;
import com.baseddevs.userservice.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<ApiResponse<RoleDTO>> createRole(@RequestBody RoleCU roleCU) {
        RoleDTO roleDTO = roleService.createRole(roleCU);
        ApiResponse<RoleDTO> response = new ApiResponse<>(ZonedDateTime.now(), "success", roleDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<RoleDTO>>> getAllRoles() {
        List<RoleDTO> roles = roleService.getAllRoles();
        ApiResponse<List<RoleDTO>> response = new ApiResponse<>(ZonedDateTime.now(), "success", roles);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<RoleDTO>> getRoleById(@PathVariable Long id) {
        RoleDTO roleDTO = roleService.getRoleById(id);
        ApiResponse<RoleDTO> response = new ApiResponse<>(ZonedDateTime.now(), "success", roleDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<RoleDTO>> updateRole(@PathVariable Long id, @RequestBody RoleCU roleCU) {
        RoleDTO updatedRole = roleService.updateRole(id, roleCU);
        ApiResponse<RoleDTO> response = new ApiResponse<>(ZonedDateTime.now(), "success", updatedRole);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        ApiResponse<String> response = new ApiResponse<>(ZonedDateTime.now(), "success", "Role deleted");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
