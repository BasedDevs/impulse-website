package com.baseddevs.userservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank(message = "Street cannot be blank/null")
    @Column(name = "street", nullable = false)
    private String street;

    @NotBlank(message = "City cannot be blank/null")
    @Column(name = "city", nullable = false)
    private String city;

    @NotBlank(message = "State cannot be blank/null")
    @Column(name = "state")
    private String state;

    @NotBlank(message = "Zip code cannot be blank/null")
    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @NotBlank(message = "Country cannot be blank/null")
    @Column(name = "country", nullable = false)
    private String country;
}