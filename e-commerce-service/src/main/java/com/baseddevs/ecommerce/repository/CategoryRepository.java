package com.baseddevs.ecommerce.repository;

import com.baseddevs.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}