package com.baseddevs.ecommerce.mapper;

import com.baseddevs.ecommerce.dto.PromoCodeDTO;
import com.baseddevs.ecommerce.model.PromoCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PromoCodeMapper {

    public PromoCodeDTO toDTO(PromoCode promoCode) {
        PromoCodeDTO promoCodeDTO = new PromoCodeDTO();
        promoCodeDTO.setId(promoCode.getId());
        promoCodeDTO.setCode(promoCode.getCode());
        promoCodeDTO.setDiscount(promoCode.getDiscount());
        promoCodeDTO.setStartDate(promoCode.getStartDate());
        promoCodeDTO.setEndDate(promoCode.getEndDate());
        return promoCodeDTO;
    }

}
