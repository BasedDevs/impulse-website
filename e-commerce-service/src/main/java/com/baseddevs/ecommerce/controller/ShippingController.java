package com.baseddevs.ecommerce.controller;

import com.baseddevs.ecommerce.dto.ShippingDTO;
import com.baseddevs.ecommerce.exception.dto.ApiResponse;
import com.baseddevs.ecommerce.service.ShippingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shippings")
public class ShippingController {

    private final ShippingService shippingService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ShippingDTO>>> getAllShippings() {
        List<ShippingDTO> categories = shippingService.getAll();
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Shippings fetched successfully", categories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ShippingDTO>> getShippingById(@PathVariable Long id) {
        ShippingDTO category = shippingService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Shipping fetched successfully", category));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ShippingDTO>> createShipping(@Valid @RequestBody ShippingDTO categoryDTO) {
        ShippingDTO category = shippingService.create(categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Shipping created successfully", category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ShippingDTO>> updateShipping(@PathVariable Long id, @Valid @RequestBody ShippingDTO categoryDTO) {
        ShippingDTO category = shippingService.update(id, categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Shipping updated successfully", category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteShipping(@PathVariable Long id) {
        shippingService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Shipping deleted successfully", null));
    }
}
