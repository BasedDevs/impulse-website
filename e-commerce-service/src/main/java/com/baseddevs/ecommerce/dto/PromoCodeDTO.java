package com.baseddevs.ecommerce.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class PromoCodeDTO {
    private Long id;
    private String code;
    private BigDecimal discount;
    private Instant startDate;
    private Instant endDate;
}