package com.baseddevs.service;

import com.baseddevs.dto.CategoryCreateDTO;
import com.baseddevs.dto.CategoryDTO;
import com.baseddevs.dto.CategoryUpdateDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(Long categoryId);

    CategoryDTO createCategory(CategoryCreateDTO categoryCreateDTO);

    CategoryDTO updateCategoryById(Long categoryId, CategoryUpdateDTO categoryUpdateDTO);

    void deleteCategoryById(Long categoryId);
}

