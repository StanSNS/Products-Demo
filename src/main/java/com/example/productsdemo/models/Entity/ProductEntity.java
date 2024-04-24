package com.example.productsdemo.models.Entity;

import com.example.productsdemo.models.Entity.BaseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "products")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity extends BaseEntity {
    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double discountPercentage;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String category;

    @Column(columnDefinition = "TEXT")
    private String thumbnail;
}
