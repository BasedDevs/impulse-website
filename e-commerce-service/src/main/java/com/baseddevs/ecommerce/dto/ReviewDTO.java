package com.baseddevs.ecommerce.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ReviewDTO {
    private Long id;
    private ProductDTO product;
    private Long userId;
    private Integer rating;
    private String comment;
    private Instant reviewDate;
}