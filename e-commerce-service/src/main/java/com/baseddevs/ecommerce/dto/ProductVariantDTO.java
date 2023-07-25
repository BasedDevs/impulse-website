package com.baseddevs.ecommerce.dto;

import lombok.Data;

@Data
public class ProductVariantDTO {
    private Long id;
    private ProductDTO product;
    public String size;
    public String color;
}