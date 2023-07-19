package com.baseddevs.mappers;

import com.baseddevs.dto.ProductDTO;
import com.baseddevs.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductMapper {

    private final CategoryMapper categoryMapper;
    private final GenderMapper genderMapper;

    public ProductDTO toDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                categoryMapper.toDTO(product.getCategory()),
                genderMapper.toDTO(product.getGender()),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
