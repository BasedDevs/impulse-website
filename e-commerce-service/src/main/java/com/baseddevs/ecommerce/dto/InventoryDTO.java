package com.baseddevs.dto;

import jakarta.validation.constraints.NotNull;

public record InventoryDTO(
        Long id,
        @NotNull(message = "Product variant cannot be null") ProductVariantDTO variant,
        @NotNull(message = "Quantity cannot be null") Integer quantity
) {

}