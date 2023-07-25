package com.baseddevs.ecommerce.controller;

import com.baseddevs.ecommerce.dto.ProductVariantDTO;
import com.baseddevs.ecommerce.exception.dto.ApiResponse;
import com.baseddevs.ecommerce.service.ProductVariantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product-variants")
public class ProductVariantController {

    private final ProductVariantService productVariantService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductVariantDTO>>> getAllProductVariants() {
        List<ProductVariantDTO> categories = productVariantService.getAll();
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "ProductVariants fetched successfully", categories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductVariantDTO>> getProductVariantById(@PathVariable Long id) {
        ProductVariantDTO category = productVariantService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "ProductVariant fetched successfully", category));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductVariantDTO>> createProductVariant(@Valid @RequestBody ProductVariantDTO categoryDTO) {
        ProductVariantDTO category = productVariantService.create(categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "ProductVariant created successfully", category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductVariantDTO>> updateProductVariant(@PathVariable Long id, @Valid @RequestBody ProductVariantDTO categoryDTO) {
        ProductVariantDTO category = productVariantService.update(id, categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "ProductVariant updated successfully", category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProductVariant(@PathVariable Long id) {
        productVariantService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "ProductVariant deleted successfully", null));
    }
}
