package com.baseddevs.impulsebackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

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

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @NotBlank(message = "Shipping method cannot be blank/null")
    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "shipping_date")
    private Date shippingDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;
}