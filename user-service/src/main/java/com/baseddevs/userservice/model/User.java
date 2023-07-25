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
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NotBlank(message = "Email cannot be blank/null")
    @Email(message = "Email should be valid")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Hashed password cannot be blank/null")
    @Size(min = 1, max = 200, message = "Hashed password must be between 1 and 200 characters")
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank(message = "First Name cannot be blank/null")
    @Size(max = 50, message = "First name must be maximum 50 characters")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank/null")
    @Size(max = 50, message = "Last name must be maximum 50 characters")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Address> addresses = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<RefreshToken> refreshTokens;

    @Column(name = "account_non_expired", nullable = false)
    private boolean accountNonExpired = true;

    @Column(name = "account_non_locked", nullable = false)
    private boolean accountNonLocked = true;

    @Column(name = "credentials_non_expired", nullable = false)
    private boolean credentialsNonExpired = true;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Column(name = "email_verified", nullable = false)
    private boolean emailVerified = false;

    @Column(name = "confirmation_token")
    private String confirmationToken;

}