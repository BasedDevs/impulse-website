package com.baseddevs.ecommerce.mapper;

import com.baseddevs.ecommerce.dto.CategoryDTO;
import com.baseddevs.ecommerce.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryMapper {

    public CategoryDTO toDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDeleted(category.getIsDeleted());
        return categoryDTO;
    }

}
