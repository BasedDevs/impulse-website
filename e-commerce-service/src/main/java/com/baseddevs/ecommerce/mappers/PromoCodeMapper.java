package com.baseddevs.mappers;

import com.baseddevs.dto.PromoCodeDTO;
import com.baseddevs.model.PromoCode;
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