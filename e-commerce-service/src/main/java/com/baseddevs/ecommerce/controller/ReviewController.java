package com.baseddevs.ecommerce.controller;

import com.baseddevs.ecommerce.dto.ReviewDTO;
import com.baseddevs.ecommerce.exception.dto.ApiResponse;
import com.baseddevs.ecommerce.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ReviewDTO>>> getAllReviews() {
        List<ReviewDTO> categories = reviewService.getAll();
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Reviews fetched successfully", categories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ReviewDTO>> getReviewById(@PathVariable Long id) {
        ReviewDTO category = reviewService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Review fetched successfully", category));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ReviewDTO>> createReview(@Valid @RequestBody ReviewDTO categoryDTO) {
        ReviewDTO category = reviewService.create(categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Review created successfully", category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ReviewDTO>> updateReview(@PathVariable Long id, @Valid @RequestBody ReviewDTO categoryDTO) {
        ReviewDTO category = reviewService.update(id, categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Review updated successfully", category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteReview(@PathVariable Long id) {
        reviewService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Review deleted successfully", null));
    }
}
