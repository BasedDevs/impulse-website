package com.baseddevs.impulsebackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inventories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Product variant cannot be null")
    @OneToOne
    @JoinColumn(name = "variant_id")
    private ProductVariant variant;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 0, message = "The value must be positive or zero")
    @Column(name = "quantity")
    private Integer quantity;

}
