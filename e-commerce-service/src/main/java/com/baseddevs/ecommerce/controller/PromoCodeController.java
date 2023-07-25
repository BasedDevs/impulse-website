package com.baseddevs.ecommerce.controller;

import com.baseddevs.ecommerce.dto.PromoCodeDTO;
import com.baseddevs.ecommerce.exception.dto.ApiResponse;
import com.baseddevs.ecommerce.service.PromoCodeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/promo-codes")
public class PromoCodeController {

    private final PromoCodeService promoCodeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<PromoCodeDTO>>> getAllPromoCodes() {
        List<PromoCodeDTO> categories = promoCodeService.getAll();
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "PromoCodes fetched successfully", categories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PromoCodeDTO>> getPromoCodeById(@PathVariable Long id) {
        PromoCodeDTO category = promoCodeService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "PromoCode fetched successfully", category));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PromoCodeDTO>> createPromoCode(@Valid @RequestBody PromoCodeDTO categoryDTO) {
        PromoCodeDTO category = promoCodeService.create(categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "PromoCode created successfully", category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PromoCodeDTO>> updatePromoCode(@PathVariable Long id, @Valid @RequestBody PromoCodeDTO categoryDTO) {
        PromoCodeDTO category = promoCodeService.update(id, categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "PromoCode updated successfully", category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePromoCode(@PathVariable Long id) {
        promoCodeService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "PromoCode deleted successfully", null));
    }
}
