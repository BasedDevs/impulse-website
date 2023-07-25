package com.baseddevs.ecommerce.mapper;

import com.baseddevs.ecommerce.dto.ProductVariantDTO;
import com.baseddevs.ecommerce.model.ProductVariant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductVariantMapper {

    private final ProductMapper productMapper;

    public ProductVariantDTO toDTO(ProductVariant productVariant) {
        ProductVariantDTO productVariantDTO = new ProductVariantDTO();
        productVariantDTO.setId(productVariant.getId());
        productVariantDTO.setProduct(productMapper.toDTO(productVariant.getProduct()));
        productVariantDTO.setSize(productVariant.getSize());
        productVariantDTO.setColor(productVariant.getColor());
        return productVariantDTO;
    }

}
