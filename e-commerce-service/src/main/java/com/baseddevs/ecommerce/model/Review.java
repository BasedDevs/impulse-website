package com.baseddevs.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Product cannot be null")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "user_id")
    private Long userId;

    @Min(1)
    @Max(5)
    @Column(name = "rating")
    private Integer rating;

    @Size(max = 500, message = "Comment must be maximum 500 characters")
    @Column(name = "comment")
    private String comment;

    @NotNull(message = "Review date cannot be null")
    @Column(name = "review_date")
    private Instant reviewDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

}