package com.baseddevs.ecommerce.service;

import com.baseddevs.ecommerce.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO create(OrderDTO orderDTO);

    OrderDTO getById(Long id);

    OrderDTO update(Long id, OrderDTO orderDTO);

    void delete(Long id);

    List<OrderDTO> getAll();
}