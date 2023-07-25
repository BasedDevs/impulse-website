package com.baseddevs.ecommerce.model;

import com.baseddevs.ecommerce.model.enums.ShippingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "shippings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "address_id")
    private Long addressId;

    @NotBlank(message = "Shipping method cannot be blank/null")
    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "shipping_date")
    private Instant shippingDate;

    @Column(name = "delivery_date")
    private Instant deliveryDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ShippingStatus status;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;
}