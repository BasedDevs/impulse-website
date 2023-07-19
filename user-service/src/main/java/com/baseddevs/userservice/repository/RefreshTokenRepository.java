package com.baseddevs.userservice.repository;

import com.baseddevs.userservice.model.RefreshToken;
import com.baseddevs.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
}
