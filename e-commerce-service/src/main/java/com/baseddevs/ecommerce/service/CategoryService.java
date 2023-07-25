package com.baseddevs.ecommerce.service;

import com.baseddevs.ecommerce.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO create(CategoryDTO categoryDTO);

    CategoryDTO getById(Long id);

    CategoryDTO update(Long id, CategoryDTO categoryDTO);

    void delete(Long id);

    List<CategoryDTO> getAll();
}