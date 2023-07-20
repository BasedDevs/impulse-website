package com.baseddevs.userservice.runner;

import com.baseddevs.userservice.model.*;
import com.baseddevs.userservice.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
public class DataLoader {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initData(RoleRepository roleRepository, PermissionRepository permissionRepository, RolePermissionRepository rolePermissionRepository) {
        return (args) -> {
            // Create roles
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);

            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);

            // Create permissions
            Permission readPermission = new Permission();
            readPermission.setName("READ");
            permissionRepository.save(readPermission);

            Permission writePermission = new Permission();
            writePermission.setName("WRITE");
            permissionRepository.save(writePermission);

            Permission deletePermission = new Permission();
            deletePermission.setName("DELETE");
            permissionRepository.save(deletePermission);

            Permission updatePermission = new Permission();
            updatePermission.setName("UPDATE");
            permissionRepository.save(updatePermission);

            // Assign permissions to roles
            RolePermission adminReadPermission = new RolePermission();
            adminReadPermission.setRole(adminRole);
            adminReadPermission.setPermission(readPermission);
            rolePermissionRepository.save(adminReadPermission);

            RolePermission adminWritePermission = new RolePermission();
            adminWritePermission.setRole(adminRole);
            adminWritePermission.setPermission(writePermission);
            rolePermissionRepository.save(adminWritePermission);

            RolePermission userReadPermission = new RolePermission();
            userReadPermission.setRole(userRole);
            userReadPermission.setPermission(readPermission);
            rolePermissionRepository.save(userReadPermission);

            // Create users
            User user1 = new User();
            user1.setUsername("admin");
            user1.setEmail("prica.o.sam@gmail.com");
            user1.setPassword(passwordEncoder.encode("admin"));
            user1.setFirstName("Admin");
            user1.setLastName("Admin");

            userRepository.save(user1);

            UserRole userRole1 = new UserRole();
            userRole1.setUser(user1);
            userRole1.setRole(adminRole);

            userRoleRepository.save(userRole1);

            User user2 = new User();
            user2.setUsername("user");
            user2.setEmail("user@user.com");
            user2.setPassword(passwordEncoder.encode("user"));
            user2.setFirstName("User");
            user2.setLastName("User");

            userRepository.save(user2);

            UserRole userRole2 = new UserRole();
            userRole2.setUser(user2);
            userRole2.setRole(userRole);

            userRoleRepository.save(userRole2);

        };
    }
}