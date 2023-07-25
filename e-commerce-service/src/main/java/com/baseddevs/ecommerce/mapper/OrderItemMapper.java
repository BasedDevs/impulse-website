package com.baseddevs.ecommerce.mapper;

import com.baseddevs.ecommerce.dto.OrderItemDTO;
import com.baseddevs.ecommerce.model.OrderItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderItemMapper {

    private final ProductVariantMapper productVariantMapper;

    public OrderItemDTO toDTO(OrderItem orderItem) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setId(orderItem.getId());
        orderItemDTO.setOrderId(orderItem.getOrder().getId());
        orderItemDTO.setVariant(productVariantMapper.toDTO(orderItem.getVariant()));
        orderItemDTO.setQuantity(orderItem.getQuantity());
        orderItemDTO.setPrice(orderItem.getPrice());
        return orderItemDTO;
    }

}
