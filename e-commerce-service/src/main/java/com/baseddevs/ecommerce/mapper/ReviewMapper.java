package com.baseddevs.ecommerce.mapper;

import com.baseddevs.ecommerce.dto.ReviewDTO;
import com.baseddevs.ecommerce.model.Review;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReviewMapper {

    private final ProductMapper productMapper;

    public ReviewDTO toDTO(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setProduct(productMapper.toDTO(review.getProduct()));
        reviewDTO.setUserId(review.getUserId());
        reviewDTO.setRating(review.getRating());
        reviewDTO.setComment(review.getComment());
        reviewDTO.setReviewDate(review.getReviewDate());
        return reviewDTO;
    }

}
