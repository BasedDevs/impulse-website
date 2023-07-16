package com.baseddevs.impulsebackend.service;

import com.baseddevs.impulsebackend.dto.ProductCreateDTO;
import com.baseddevs.impulsebackend.dto.ProductDTO;
import com.baseddevs.impulsebackend.dto.ProductUpdateDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long productId);

    ProductDTO createProduct(ProductCreateDTO product);

    ProductDTO updateProduct(Long productId, ProductUpdateDTO product);

    void deleteProduct(Long productId);
}
