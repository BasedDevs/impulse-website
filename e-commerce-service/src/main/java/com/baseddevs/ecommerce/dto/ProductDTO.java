package com.baseddevs.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductDTO(
        Long id,
        @NotNull(message = "Category cannot be null") CategoryDTO categoryDTO,
        @NotNull(message = "Gender cannot be null") GenderDTO genderDTO,
        @NotBlank(message = "Product name cannot be blank/null")
        @Size(min = 1, max = 100, message = "Product name must be between 1 and 100 characters") String name,
        @Size(max = 1000, message = "Product description must be maximum 1000 characters") String description,
        @NotNull(message = "Price cannot be null")
        @Min(value = 0, message = "The value must be positive")
        @Digits(integer = 10, fraction = 2, message = "Max 10 integer and 2 fraction digits are allowed for price")
        BigDecimal price
) {

}