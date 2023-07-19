package com.baseddevs.service;

import com.baseddevs.dto.ProductCreateDTO;
import com.baseddevs.dto.ProductDTO;
import com.baseddevs.dto.ProductUpdateDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long productId);

    ProductDTO createProduct(ProductCreateDTO product);

    ProductDTO updateProduct(Long productId, ProductUpdateDTO product);

    void deleteProduct(Long productId);
}
