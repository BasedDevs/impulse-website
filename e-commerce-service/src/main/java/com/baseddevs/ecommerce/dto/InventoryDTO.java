package com.baseddevs.ecommerce.dto;

import lombok.Data;

@Data
public class InventoryDTO {
    private Long id;
    private ProductVariantDTO variant;
    private Integer quantity;
    private String sku;
}