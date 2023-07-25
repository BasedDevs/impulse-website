package com.baseddevs.ecommerce.service.impl;

import com.baseddevs.ecommerce.dto.OrderItemDTO;
import com.baseddevs.ecommerce.exception.utils.ExceptionUtils;
import com.baseddevs.ecommerce.mapper.OrderItemMapper;
import com.baseddevs.ecommerce.repository.OrderItemRepository;
import com.baseddevs.ecommerce.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;
    private final ExceptionUtils exceptionUtils;

    @Override
    public OrderItemDTO create(OrderItemDTO orderItemDTO) {
        return null;
    }

    @Override
    public OrderItemDTO getById(Long id) {
        return null;
    }

    @Override
    public OrderItemDTO update(Long id, OrderItemDTO orderItemDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<OrderItemDTO> getAll() {
        return null;
    }
}