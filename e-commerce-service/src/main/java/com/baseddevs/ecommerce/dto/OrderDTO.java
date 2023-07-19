package com.baseddevs.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Date;

public record OrderDTO(
        Long id,
        UserDTO user,
        PromoCodeDTO promoCodeDTO,
        Date orderDate,
        @NotNull(message = "Total amount cannot be null") BigDecimal totalAmount
) {

}