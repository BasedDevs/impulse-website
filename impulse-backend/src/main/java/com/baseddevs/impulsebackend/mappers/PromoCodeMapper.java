package com.baseddevs.impulsebackend.mappers;

import com.baseddevs.impulsebackend.dto.PromoCodeDTO;
import com.baseddevs.impulsebackend.model.PromoCode;
import org.springframework.stereotype.Component;

@Component
public class PromoCodeMapper {

    public PromoCodeDTO toDTO(PromoCode promoCode) {
        return new PromoCodeDTO(
                promoCode.getId(),
                promoCode.getCode(),
                promoCode.getDiscount(),
                promoCode.getStartDate(),
                promoCode.getEndDate()
        );
    }
}