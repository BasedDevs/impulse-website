package com.baseddevs.service;

import com.baseddevs.dto.OrderCreateDTO;
import com.baseddevs.dto.OrderDTO;
import com.baseddevs.dto.OrderUpdateDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(Long orderId);

    OrderDTO createOrder(OrderCreateDTO order);

    OrderDTO updateOrderById(Long orderId, OrderUpdateDTO order);

    void deleteOrderById(Long orderId);
}
