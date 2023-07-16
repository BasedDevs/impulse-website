package com.baseddevs.impulsebackend.mappers;

import com.baseddevs.impulsebackend.dto.CategoryDTO;
import com.baseddevs.impulsebackend.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDTO toDTO(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getName()
        );
    }
}