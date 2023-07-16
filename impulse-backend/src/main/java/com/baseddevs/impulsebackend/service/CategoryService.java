package com.baseddevs.impulsebackend.service;

import com.baseddevs.impulsebackend.dto.CategoryCreateDTO;
import com.baseddevs.impulsebackend.dto.CategoryDTO;
import com.baseddevs.impulsebackend.dto.CategoryUpdateDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(Long categoryId);

    CategoryDTO createCategory(CategoryCreateDTO categoryCreateDTO);

    CategoryDTO updateCategoryById(Long categoryId, CategoryUpdateDTO categoryUpdateDTO);

    void deleteCategoryById(Long categoryId);
}

