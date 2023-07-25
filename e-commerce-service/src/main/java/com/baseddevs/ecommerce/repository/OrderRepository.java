package com.baseddevs.ecommerce.repository;

import com.baseddevs.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}