package com.baseddevs.ecommerce.controller;

import com.baseddevs.ecommerce.dto.OrderDTO;
import com.baseddevs.ecommerce.exception.dto.ApiResponse;
import com.baseddevs.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderDTO>>> getAllOrders() {
        List<OrderDTO> categories = orderService.getAll();
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Orders fetched successfully", categories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderDTO>> getOrderById(@PathVariable Long id) {
        OrderDTO category = orderService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Order fetched successfully", category));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<OrderDTO>> createOrder(@Valid @RequestBody OrderDTO categoryDTO) {
        OrderDTO category = orderService.create(categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Order created successfully", category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderDTO>> updateOrder(@PathVariable Long id, @Valid @RequestBody OrderDTO categoryDTO) {
        OrderDTO category = orderService.update(id, categoryDTO);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Order updated successfully", category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(ZonedDateTime.now(), "Order deleted successfully", null));
    }
}
