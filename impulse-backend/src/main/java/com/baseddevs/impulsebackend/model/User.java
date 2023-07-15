package com.baseddevs.impulsebackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

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
    @Size(min=1, max=50, message = "Username must be between 1 and 50 characters")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Email cannot be blank/null")
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Hashed password cannot be blank/null")
    @Size(min=1, max=200, message = "Hashed password must be between 1 and 200 characters")
    @Column(name = "hashed_password")
    private String hashedPassword;

    @NotBlank(message = "First Name cannot be blank/null")
    @Size(max=50, message = "First name must be maximum 50 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank/null")
    @Size(max=50, message = "Last name must be maximum 50 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Registration date cannot be null")
    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "last_login_date")
    private Date lastLoginDate;

}
