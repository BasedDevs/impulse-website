package com.baseddevs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record GenderDTO(
        Long id,
        @NotBlank(message = "Gender cannot be blank/null")
        @Size(min = 1, max = 50, message = "Gender must be between 1 and 50 characters") String gender
) {

}