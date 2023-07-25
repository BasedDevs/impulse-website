package com.baseddevs.ecommerce.controller;

import com.baseddevs.ecommerce.dto.InventoryDTO;
import com.baseddevs.ecommerce.exception.dto.ApiResponse;
import com.baseddevs.ecommerce.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventories")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<InventoryDTO>>> getAllInventories() {
        List<InventoryDTO> categories = inventoryService.getAll();
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Inventories fetched successfully", categories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<InventoryDTO>> getInventoryById(@PathVariable Long id) {
        InventoryDTO category = inventoryService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Inventory fetched successfully", category));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<InventoryDTO>> createInventory(@Valid @RequestBody InventoryDTO categoryDTO) {
        InventoryDTO category = inventoryService.create(categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Inventory created successfully", category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<InventoryDTO>> updateInventory(@PathVariable Long id, @Valid @RequestBody InventoryDTO categoryDTO) {
        InventoryDTO category = inventoryService.update(id, categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Inventory updated successfully", category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteInventory(@PathVariable Long id) {
        inventoryService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Inventory deleted successfully", null));
    }
}
