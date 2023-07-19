package com.baseddevs.mappers;

import com.baseddevs.dto.ReviewDTO;
import com.baseddevs.model.Review;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReviewMapper {

    private final ProductMapper productMapper;
    private final UserMapper userMapper;

    public ReviewDTO toDTO(Review review) {
        return new ReviewDTO(
                review.getId(),
                productMapper.toDTO(review.getProduct()),
                review.getUser() != null ? userMapper.toDTO(review.getUser()) : null,
                review.getRating(),
                review.getComment(),
                review.getReviewDate()
        );
    }
}