package com.baseddevs.ecommerce.repository;

import com.baseddevs.ecommerce.model.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoCodeRepository extends JpaRepository<PromoCode, Long> {
}