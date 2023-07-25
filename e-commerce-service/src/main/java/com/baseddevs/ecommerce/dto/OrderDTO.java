package com.baseddevs.ecommerce.dto;

import com.baseddevs.ecommerce.model.enums.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class OrderDTO {
    private Long id;
    private Long userId;
    private PromoCodeDTO promoCode;
    private Instant orderDate;
    private BigDecimal totalAmount;
    private OrderStatus status;
}