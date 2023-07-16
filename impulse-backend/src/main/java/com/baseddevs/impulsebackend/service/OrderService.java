package com.baseddevs.impulsebackend.service;

import com.baseddevs.impulsebackend.dto.OrderCreateDTO;
import com.baseddevs.impulsebackend.dto.OrderDTO;
import com.baseddevs.impulsebackend.dto.OrderUpdateDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(Long orderId);

    OrderDTO createOrder(OrderCreateDTO order);

    OrderDTO updateOrderById(Long orderId, OrderUpdateDTO order);

    void deleteOrderById(Long orderId);
}
