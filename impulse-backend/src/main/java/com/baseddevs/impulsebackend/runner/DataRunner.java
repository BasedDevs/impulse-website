package com.baseddevs.impulsebackend.runner;

import com.baseddevs.impulsebackend.model.*;
import com.baseddevs.impulsebackend.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class DataRunner implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final RolePermissionRepository rolePermissionRepository;
    private final UserRoleRepository userRoleRepository;
    private final CategoryRepository categoryRepository;
    private final GenderRepository genderRepository;
    private final ProductRepository productRepository;
    private final ProductVariantRepository productVariantRepository;
    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional
    public void run(String... args) {
        // Save some categories
        Category category1 = new Category(1L, "Electronics");
        Category category2 = new Category(2L, "Books");
        categoryRepository.save(category1);
        categoryRepository.save(category2);

        // Save some genders
        Gender gender1 = new Gender(1L, "Male");
        Gender gender2 = new Gender(2L, "Female");
        genderRepository.save(gender1);
        genderRepository.save(gender2);

        // Save a product
        Product product = new Product(1L, category1, gender1, "iPhone", "Apple iPhone 13", BigDecimal.valueOf(999.99));
        productRepository.save(product);

        // Save a product variant
        ProductVariant productVariant = new ProductVariant(1L, product, "Large", "Black");
        productVariantRepository.save(productVariant);

        // Save an inventory
        Inventory inventory = new Inventory(1L, productVariant, 10);
        inventoryRepository.save(inventory);

        // Save some permissions
        Permission permission1 = new Permission(1L, "read");
        Permission permission2 = new Permission(2L, "write");
        permission1 = permissionRepository.save(permission1);
        permissionRepository.save(permission2);

        // Save a role
        Role role = new Role(1L, "admin", new HashSet<>());
        role = roleRepository.save(role);

        // Save a role permission
        RolePermission rolePermission = new RolePermission(1L, role, permission1);
        rolePermissionRepository.save(rolePermission);

        // Save a user
        User user = new User(1L, "user1", "user1@example.com", "hashedPassword", "John", "Doe", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()));
        userRepository.save(user);

        // Save a user role
        UserRole userRole = new UserRole(1L, user, role);
        userRoleRepository.save(userRole);
    }
}
