package com.baseddevs.ecommerce.mapper;

import com.baseddevs.ecommerce.dto.ShippingDTO;
import com.baseddevs.ecommerce.model.Shipping;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShippingMapper {

    private final OrderMapper orderMapper;

    public ShippingDTO toDTO(Shipping shipping) {
        ShippingDTO shippingDTO = new ShippingDTO();
        shippingDTO.setId(shipping.getId());
        shippingDTO.setOrder(orderMapper.toDTO(shipping.getOrder()));
        shippingDTO.setAddressId(shipping.getAddressId());
        shippingDTO.setShippingMethod(shipping.getShippingMethod());
        shippingDTO.setShippingDate(shipping.getShippingDate());
        shippingDTO.setDeliveryDate(shipping.getDeliveryDate());
        shippingDTO.setStatus(shipping.getStatus());
        return shippingDTO;
    }

}
