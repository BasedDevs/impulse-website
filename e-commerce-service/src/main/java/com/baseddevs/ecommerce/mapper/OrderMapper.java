package com.baseddevs.ecommerce.mapper;

import com.baseddevs.ecommerce.dto.OrderDTO;
import com.baseddevs.ecommerce.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderMapper {

    private final PromoCodeMapper promoCodeMapper;

    public OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setUserId(order.getUserId());
        orderDTO.setPromoCode(promoCodeMapper.toDTO(order.getPromoCode()));
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setTotalAmount(order.getTotalAmount());
        orderDTO.setStatus(order.getStatus());
        return orderDTO;
    }

}
