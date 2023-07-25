package com.baseddevs.ecommerce.repository;

import com.baseddevs.ecommerce.model.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
}