package com.baseddevs.impulsebackend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;

public record ReviewDTO(
        Long id,
        @NotNull(message = "Product cannot be null") ProductDTO product,
        UserDTO user,
        @Min(1) @Max(5) Integer rating,
        @Size(max = 500, message = "Comment must be maximum 500 characters") String comment,
        @NotNull(message = "Review date cannot be null") Date reviewDate
) {

}