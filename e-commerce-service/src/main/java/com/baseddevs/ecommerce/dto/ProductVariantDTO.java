package com.baseddevs.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductVariantDTO(
        Long id,
        @NotNull(message = "Product cannot be null") ProductDTO productDTO,
        @Size(max = 50, message = "Size must be maximum 50 characters") String size,
        @Size(max = 50, message = "Color must be maximum 50 characters") String color
) {

}