package com.baseddevs.ecommerce.dto;

import com.baseddevs.ecommerce.model.enums.Gender;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private CategoryDTO category;
    private Gender gender;
    private String name;
    private String description;
    private BigDecimal price;
}