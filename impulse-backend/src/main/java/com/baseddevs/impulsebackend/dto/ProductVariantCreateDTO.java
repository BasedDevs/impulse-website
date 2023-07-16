package com.baseddevs.impulsebackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductVariantCreateDTO(
        @NotNull(message = "Product cannot be null") ProductDTO productDTO,
        @Size(max = 50, message = "Size must be maximum 50 characters") String size,
        @Size(max = 50, message = "Color must be maximum 50 characters") String color
) {

}