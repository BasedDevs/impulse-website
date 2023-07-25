package com.baseddevs.ecommerce.service.impl;

import com.baseddevs.ecommerce.dto.ProductVariantDTO;
import com.baseddevs.ecommerce.exception.utils.ExceptionUtils;
import com.baseddevs.ecommerce.mapper.ProductVariantMapper;
import com.baseddevs.ecommerce.repository.ProductVariantRepository;
import com.baseddevs.ecommerce.service.ProductVariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductVariantServiceImpl implements ProductVariantService {

    private final ProductVariantRepository productVariantRepository;
    private final ProductVariantMapper productVariantMapper;
    private final ExceptionUtils exceptionUtils;
    @Override
    public ProductVariantDTO create(ProductVariantDTO productVariantDTO) {
        return null;
    }

    @Override
    public ProductVariantDTO getById(Long id) {
        return null;
    }

    @Override
    public ProductVariantDTO update(Long id, ProductVariantDTO productVariantDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ProductVariantDTO> getAll() {
        return null;
    }
}