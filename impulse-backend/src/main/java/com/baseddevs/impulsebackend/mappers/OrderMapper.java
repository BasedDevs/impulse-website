package com.baseddevs.impulsebackend.mappers;

import com.baseddevs.impulsebackend.dto.OrderDTO;
import com.baseddevs.impulsebackend.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderMapper {

    private final UserMapper userMapper;
    private final PromoCodeMapper promoCodeMapper;

    public OrderDTO toDTO(Order order) {
        return new OrderDTO(
                order.getId(),
                userMapper.toDTO(order.getUser()),
                order.getPromoCode() != null ? promoCodeMapper.toDTO(order.getPromoCode()) : null,
                order.getOrderDate(),
                order.getTotalAmount()
        );
    }
}