package com.baseddevs.userservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Username cannot be blank/null")
    @Size(min = 1, max = 50, message = "Username must be between 1 and 50 characters")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Email cannot be blank/null")
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Hashed password cannot be blank/null")
    @Size(min = 1, max = 200, message = "Hashed password must be between 1 and 200 characters")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "First Name cannot be blank/null")
    @Size(max = 50, message = "First name must be maximum 50 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank/null")
    @Size(max = 50, message = "Last name must be maximum 50 characters")
    @Column(name = "last_name")
    private String lastName;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoles = new HashSet<>();

    @Column(name = "account_non_expired")
    private boolean accountNonExpired = true;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked = true;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired = true;

    @Column(name = "enabled")
    private boolean enabled = true;

    @Column(name = "email_verified")
    private boolean emailVerified = false;

    @Column(name = "confirmation_token")
    private String confirmationToken;

}