package com.baseddevs.impulsebackend.service;

import com.baseddevs.impulsebackend.dto.ReviewCreateDTO;
import com.baseddevs.impulsebackend.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {

    List<ReviewDTO> getAllReviewsForProduct(Long productId);

    ReviewDTO addReviewForProduct(Long productId, ReviewCreateDTO reviewDto);

}
