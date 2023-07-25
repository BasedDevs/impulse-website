package com.baseddevs.ecommerce.controller;

import com.baseddevs.ecommerce.dto.ProductDTO;
import com.baseddevs.ecommerce.exception.dto.ApiResponse;
import com.baseddevs.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAllProducts() {
        List<ProductDTO> categories = productService.getAll();
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Products fetched successfully", categories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> getProductById(@PathVariable Long id) {
        ProductDTO category = productService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Product fetched successfully", category));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDTO>> createProduct(@Valid @RequestBody ProductDTO categoryDTO) {
        ProductDTO category = productService.create(categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Product created successfully", category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO categoryDTO) {
        ProductDTO category = productService.update(id, categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Product updated successfully", category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Product deleted successfully", null));
    }
}
