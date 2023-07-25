package com.baseddevs.ecommerce.dto;

import com.baseddevs.ecommerce.model.enums.ShippingStatus;
import lombok.Data;

import java.time.Instant;

@Data
public class ShippingDTO {
    private Long id;
    private OrderDTO order;
    private Long addressId;
    private String shippingMethod;
    private Instant shippingDate;
    private Instant deliveryDate;
    private ShippingStatus status;
}