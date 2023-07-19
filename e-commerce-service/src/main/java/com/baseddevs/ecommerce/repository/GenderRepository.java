package com.baseddevs.repository;

import com.baseddevs.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GenderRepository extends JpaRepository<Gender, Long>, JpaSpecificationExecutor<Gender> {
}