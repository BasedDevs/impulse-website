package com.baseddevs.service;

import com.baseddevs.dto.ProductVariantCreateDTO;
import com.baseddevs.dto.ProductVariantDTO;
import com.baseddevs.dto.ProductVariantUpdateDTO;

import java.util.List;

public interface ProductVariantService {

    List<ProductVariantDTO> getAllVariantsForProduct(Long productId);

    ProductVariantDTO getVariantForProduct(Long productId, Long variantId);

    ProductVariantDTO createVariantForProduct(Long productId, ProductVariantCreateDTO productVariant);

    ProductVariantDTO updateVariantForProduct(Long productId, Long variantId, ProductVariantUpdateDTO productVariant);

    void deleteVariantForProduct(Long productId, Long variantId);
}
