package com.baseddevs.ecommerce.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private boolean isDeleted;
}