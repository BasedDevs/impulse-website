package com.baseddevs.impulsebackend.repository;

import com.baseddevs.impulsebackend.model.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long>, JpaSpecificationExecutor<ProductVariant> {
}