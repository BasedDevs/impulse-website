package com.baseddevs.ecommerce.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {
    private Long id;
    private Long orderId;
    private ProductVariantDTO variant;
    private Integer quantity;
    private BigDecimal price;
}