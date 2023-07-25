package com.baseddevs.ecommerce.repository;

import com.baseddevs.ecommerce.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}