package com.baseddevs.ecommerce.service.impl;

import com.baseddevs.ecommerce.dto.CategoryDTO;
import com.baseddevs.ecommerce.exception.utils.ExceptionUtils;
import com.baseddevs.ecommerce.mapper.CategoryMapper;
import com.baseddevs.ecommerce.repository.CategoryRepository;
import com.baseddevs.ecommerce.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final ExceptionUtils exceptionUtils;

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public CategoryDTO getById(Long id) {
        return null;
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<CategoryDTO> getAll() {
        return null;
    }
}