package com.baseddevs.ecommerce.controller;

import com.baseddevs.ecommerce.dto.OrderItemDTO;
import com.baseddevs.ecommerce.exception.dto.ApiResponse;
import com.baseddevs.ecommerce.service.OrderItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-items")
public class OrderItemController {

    private final OrderItemService orderService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderItemDTO>>> getAllOrderItems() {
        List<OrderItemDTO> categories = orderService.getAll();
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "OrderItems fetched successfully", categories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderItemDTO>> getOrderItemById(@PathVariable Long id) {
        OrderItemDTO category = orderService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "OrderItem fetched successfully", category));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<OrderItemDTO>> createOrderItem(@Valid @RequestBody OrderItemDTO categoryDTO) {
        OrderItemDTO category = orderService.create(categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "OrderItem created successfully", category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderItemDTO>> updateOrderItem(@PathVariable Long id, @Valid @RequestBody OrderItemDTO categoryDTO) {
        OrderItemDTO category = orderService.update(id, categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "OrderItem updated successfully", category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteOrderItem(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "OrderItem deleted successfully", null));
    }
}
