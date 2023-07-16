package com.baseddevs.impulsebackend.mappers;

import com.baseddevs.impulsebackend.dto.ProductVariantDTO;
import com.baseddevs.impulsebackend.model.ProductVariant;
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