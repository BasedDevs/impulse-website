package com.baseddevs.impulsebackend.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Date;

public record OrderCreateDTO(
        UserDTO user,
        PromoCodeDTO promoCodeDTO,
        Date orderDate,
        @NotNull(message = "Total amount cannot be null") BigDecimal totalAmount
) {

}