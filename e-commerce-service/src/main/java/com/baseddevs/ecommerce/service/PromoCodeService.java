package com.baseddevs.ecommerce.service;

import com.baseddevs.ecommerce.dto.PromoCodeDTO;

import java.util.List;

public interface PromoCodeService {
    PromoCodeDTO create(PromoCodeDTO promoCodeDTO);

    PromoCodeDTO getById(Long id);

    PromoCodeDTO update(Long id, PromoCodeDTO promoCodeDTO);

    void delete(Long id);

    List<PromoCodeDTO> getAll();
}