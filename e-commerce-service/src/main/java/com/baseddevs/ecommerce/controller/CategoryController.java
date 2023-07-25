package com.baseddevs.ecommerce.controller;

import com.baseddevs.ecommerce.dto.CategoryDTO;
import com.baseddevs.ecommerce.exception.dto.ApiResponse;
import com.baseddevs.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryDTO>>> getAllCategories() {
        List<CategoryDTO> categories = categoryService.getAll();
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Categories fetched successfully", categories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryDTO>> getCategoryById(@PathVariable Long id) {
        CategoryDTO category = categoryService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Category fetched successfully", category));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryDTO>> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO category = categoryService.create(categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Category created successfully", category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryDTO>> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO category = categoryService.update(id, categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Category updated successfully", category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Category deleted successfully", null));
    }
}
