package com.baseddevs.impulsebackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Date;

public record PromoCodeDTO(
        Long id,
        @NotBlank(message = "Code cannot be blank/null") String code,
        @NotNull(message = "Discount cannot be null") BigDecimal discount,
        Date startDate,
        Date endDate
) {

}