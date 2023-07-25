package com.baseddevs.ecommerce.service;

import com.baseddevs.ecommerce.dto.OrderItemDTO;

import java.util.List;

public interface OrderItemService {
    OrderItemDTO create(OrderItemDTO orderItemDTO);

    OrderItemDTO getById(Long id);

    OrderItemDTO update(Long id, OrderItemDTO orderItemDTO);

    void delete(Long id);

    List<OrderItemDTO> getAll();
}