package com.example.productsdemo.models.JSON;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductJson {
    private String title;
    private String description;
    private Double price;
    private Double discountPercentage;
    private Double rating;
    private Integer stock;
    private String brand;
    private String category;
    private String thumbnail;
}
