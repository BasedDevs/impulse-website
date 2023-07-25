package com.baseddevs.ecommerce.service.impl;

import com.baseddevs.ecommerce.dto.ShippingDTO;
import com.baseddevs.ecommerce.exception.utils.ExceptionUtils;
import com.baseddevs.ecommerce.mapper.ShippingMapper;
import com.baseddevs.ecommerce.repository.ShippingRepository;
import com.baseddevs.ecommerce.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShippingServiceImpl implements ShippingService {

    private final ShippingRepository shippingRepository;
    private final ShippingMapper shippingMapper;
    private final ExceptionUtils exceptionUtils;

    @Override
    public ShippingDTO create(ShippingDTO shippingDTO) {
        return null;
    }

    @Override
    public ShippingDTO getById(Long id) {
        return null;
    }

    @Override
    public ShippingDTO update(Long id, ShippingDTO shippingDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ShippingDTO> getAll() {
        return null;
    }
}