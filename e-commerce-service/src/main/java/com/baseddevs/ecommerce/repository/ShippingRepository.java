package com.baseddevs.ecommerce.repository;

import com.baseddevs.ecommerce.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}