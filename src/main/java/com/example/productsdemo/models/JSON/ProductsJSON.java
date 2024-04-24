package com.example.productsdemo.models.JSON;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductsJSON {
    private List<ProductJson> products;
}
