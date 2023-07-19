package com.baseddevs.mappers;

import com.baseddevs.dto.CategoryDTO;
import com.baseddevs.model.Category;
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