package com.baseddevs.ecommerce.service.impl;

import com.baseddevs.ecommerce.dto.ReviewDTO;
import com.baseddevs.ecommerce.exception.utils.ExceptionUtils;
import com.baseddevs.ecommerce.mapper.ReviewMapper;
import com.baseddevs.ecommerce.repository.ReviewRepository;
import com.baseddevs.ecommerce.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final ExceptionUtils exceptionUtils;
    @Override
    public ReviewDTO create(ReviewDTO reviewDTO) {
        return null;
    }

    @Override
    public ReviewDTO getById(Long id) {
        return null;
    }

    @Override
    public ReviewDTO update(Long id, ReviewDTO reviewDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ReviewDTO> getAll() {
        return null;
    }
}