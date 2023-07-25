package com.baseddevs.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "variant_id")
    private ProductVariant variant;

    @NotNull(message = "Quantity cannot be null")
    @Column(name = "quantity")
    private Integer quantity;

    @NotNull(message = "Price cannot be null")
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

}