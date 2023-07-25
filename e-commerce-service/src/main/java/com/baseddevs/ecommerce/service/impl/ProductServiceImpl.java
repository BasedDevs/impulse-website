package com.baseddevs.ecommerce.service.impl;

import com.baseddevs.ecommerce.dto.ProductDTO;
import com.baseddevs.ecommerce.exception.utils.ExceptionUtils;
import com.baseddevs.ecommerce.mapper.ProductMapper;
import com.baseddevs.ecommerce.repository.ProductRepository;
import com.baseddevs.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ExceptionUtils exceptionUtils;
    @Override
    public ProductDTO create(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO getById(Long id) {
        return null;
    }

    @Override
    public ProductDTO update(Long id, ProductDTO productDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ProductDTO> getAll() {
        return null;
    }
}