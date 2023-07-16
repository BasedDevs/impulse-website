package com.baseddevs.impulsebackend.service;

import com.baseddevs.impulsebackend.dto.ProductVariantCreateDTO;
import com.baseddevs.impulsebackend.dto.ProductVariantDTO;
import com.baseddevs.impulsebackend.dto.ProductVariantUpdateDTO;

import java.util.List;

public interface ProductVariantService {

    List<ProductVariantDTO> getAllVariantsForProduct(Long productId);

    ProductVariantDTO getVariantForProduct(Long productId, Long variantId);

    ProductVariantDTO createVariantForProduct(Long productId, ProductVariantCreateDTO productVariant);

    ProductVariantDTO updateVariantForProduct(Long productId, Long variantId, ProductVariantUpdateDTO productVariant);

    void deleteVariantForProduct(Long productId, Long variantId);
}
