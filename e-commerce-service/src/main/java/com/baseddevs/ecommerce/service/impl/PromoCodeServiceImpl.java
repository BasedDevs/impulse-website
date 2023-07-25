package com.baseddevs.ecommerce.service.impl;

import com.baseddevs.ecommerce.dto.PromoCodeDTO;
import com.baseddevs.ecommerce.exception.utils.ExceptionUtils;
import com.baseddevs.ecommerce.mapper.PromoCodeMapper;
import com.baseddevs.ecommerce.repository.PromoCodeRepository;
import com.baseddevs.ecommerce.service.PromoCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PromoCodeServiceImpl implements PromoCodeService {

    private final PromoCodeRepository promoCodeRepository;
    private final PromoCodeMapper promoCodeMapper;
    private final ExceptionUtils exceptionUtils;

    @Override
    public PromoCodeDTO create(PromoCodeDTO promoCodeDTO) {
        return null;
    }

    @Override
    public PromoCodeDTO getById(Long id) {
        return null;
    }

    @Override
    public PromoCodeDTO update(Long id, PromoCodeDTO promoCodeDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PromoCodeDTO> getAll() {
        return null;
    }
}