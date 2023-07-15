package com.baseddevs.impulsebackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Category cannot be null")
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @NotNull(message = "Gender cannot be null")
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @NotBlank(message = "Product name cannot be blank/null")
    @Size(min=1, max=100, message = "Product name must be between 1 and 100 characters")
    @Column(name = "name")
    private String name;

    @Size(max=1000, message = "Product description must be maximum 1000 characters")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "The value must be positive")
    @Digits(integer=10, fraction=2, message = "Max 10 integer and 2 fraction digits are allowed for price")
    @Column(name = "price")
    private BigDecimal price;

}
