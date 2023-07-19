package com.baseddevs.service;

import com.baseddevs.dto.ReviewCreateDTO;
import com.baseddevs.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {

    List<ReviewDTO> getAllReviewsForProduct(Long productId);

    ReviewDTO addReviewForProduct(Long productId, ReviewCreateDTO reviewDto);

}
