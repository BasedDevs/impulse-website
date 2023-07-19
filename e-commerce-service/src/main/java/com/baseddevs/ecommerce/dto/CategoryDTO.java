package com.baseddevs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryDTO(
        Long id,
        @NotBlank(message = "Category name cannot be blank/null")
        @Size(min = 1, max = 100, message = "Category name must be between 1 and 100 characters") String name
) {

}