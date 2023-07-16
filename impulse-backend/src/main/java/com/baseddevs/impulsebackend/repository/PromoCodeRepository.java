package com.baseddevs.impulsebackend.repository;

import com.baseddevs.impulsebackend.model.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PromoCodeRepository extends JpaRepository<PromoCode, Long>, JpaSpecificationExecutor<PromoCode> {
}