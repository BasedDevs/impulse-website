package com.baseddevs.ecommerce.service;

import com.baseddevs.ecommerce.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    ReviewDTO create(ReviewDTO reviewDTO);

    ReviewDTO getById(Long id);

    ReviewDTO update(Long id, ReviewDTO reviewDTO);

    void delete(Long id);

    List<ReviewDTO> getAll();
}