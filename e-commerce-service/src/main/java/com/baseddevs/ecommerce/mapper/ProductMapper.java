package com.baseddevs.ecommerce.mapper;

import com.baseddevs.ecommerce.dto.ProductDTO;
import com.baseddevs.ecommerce.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductMapper {

    private final CategoryMapper categoryMapper;

    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setCategory(categoryMapper.toDTO(product.getCategory()));
        productDTO.setGender(product.getGender());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

}
