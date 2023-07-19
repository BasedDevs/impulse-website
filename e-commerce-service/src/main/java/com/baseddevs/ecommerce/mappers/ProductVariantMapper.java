package com.baseddevs.mappers;

import com.baseddevs.dto.ProductVariantDTO;
import com.baseddevs.model.ProductVariant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductVariantMapper {

    private final ProductMapper productMapper;

    public ProductVariantDTO toDTO(ProductVariant productVariant) {
        return new ProductVariantDTO(
                productVariant.getId(),
                productMapper.toDTO(productVariant.getProduct()),
                productVariant.getSize(),
                productVariant.getColor()
        );
    }
}