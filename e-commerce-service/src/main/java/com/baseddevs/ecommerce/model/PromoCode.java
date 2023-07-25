package com.baseddevs.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "promo_codes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Code cannot be blank/null")
    @Column(name = "code")
    private String code;

    @NotNull(message = "Discount cannot be null")
    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "start_date")
    private Instant startDate;

    @Column(name = "end_date")
    private Instant endDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;
}
