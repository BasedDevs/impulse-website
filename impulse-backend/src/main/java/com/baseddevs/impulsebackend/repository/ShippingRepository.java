package com.baseddevs.impulsebackend.repository;

import com.baseddevs.impulsebackend.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShippingRepository extends JpaRepository<Shipping, Integer>, JpaSpecificationExecutor<Shipping> {
}