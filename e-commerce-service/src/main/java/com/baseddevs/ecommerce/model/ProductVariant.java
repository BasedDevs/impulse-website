package com.baseddevs.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_variants",
        indexes = @Index(columnList = "size", name = "product_size_index"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Product cannot be null")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Size(max=50, message = "Size must be maximum 50 characters")
    @Column(name = "size")
    public String size;

    @Size(max=50, message = "Color must be maximum 50 characters")
    @Column(name = "color")
    public String color;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

}
