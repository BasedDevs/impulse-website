package com.baseddevs.ecommerce.service;

import com.baseddevs.ecommerce.dto.ShippingDTO;

import java.util.List;

public interface ShippingService {
    ShippingDTO create(ShippingDTO shippingDTO);

    ShippingDTO getById(Long id);

    ShippingDTO update(Long id, ShippingDTO shippingDTO);

    void delete(Long id);

    List<ShippingDTO> getAll();
}