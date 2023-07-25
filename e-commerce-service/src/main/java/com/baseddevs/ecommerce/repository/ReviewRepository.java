package com.baseddevs.ecommerce.repository;

import com.baseddevs.ecommerce.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}