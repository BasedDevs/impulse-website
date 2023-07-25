package com.baseddevs.ecommerce.service;

import com.baseddevs.ecommerce.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO create(ProductDTO productDTO);

    ProductDTO getById(Long id);

    ProductDTO update(Long id, ProductDTO productDTO);

    void delete(Long id);

    List<ProductDTO> getAll();
}