package com.example.productsdemo.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductJson {
    @SerializedName("imageURL")
    private String imageURL;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("price")
    private double price;

    @SerializedName("quantity")
    private int quantity;
}
