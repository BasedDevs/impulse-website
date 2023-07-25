package com.baseddevs.ecommerce.service;

import com.baseddevs.ecommerce.dto.ProductVariantDTO;

import java.util.List;

public interface ProductVariantService {
    ProductVariantDTO create(ProductVariantDTO productVariantDTO);

    ProductVariantDTO getById(Long id);

    ProductVariantDTO update(Long id, ProductVariantDTO productVariantDTO);

    void delete(Long id);

    List<ProductVariantDTO> getAll();
}