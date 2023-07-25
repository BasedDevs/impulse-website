package com.baseddevs.ecommerce.service.impl;

import com.baseddevs.ecommerce.dto.OrderDTO;
import com.baseddevs.ecommerce.exception.utils.ExceptionUtils;
import com.baseddevs.ecommerce.mapper.OrderMapper;
import com.baseddevs.ecommerce.repository.OrderRepository;
import com.baseddevs.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ExceptionUtils exceptionUtils;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO getById(Long id) {
        return null;
    }

    @Override
    public OrderDTO update(Long id, OrderDTO orderDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<OrderDTO> getAll() {
        return null;
    }
}