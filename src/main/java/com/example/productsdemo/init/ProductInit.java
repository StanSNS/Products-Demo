package com.example.productsdemo.init;

import com.example.productsdemo.Repository.ProductEntityRepo;
import com.example.productsdemo.models.Entity.ProductEntity;
import com.example.productsdemo.models.JSON.ProductsJSON;
import com.google.gson.Gson;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductInit {

    private final ProductEntityRepo productEntityRepo;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @PostConstruct
    public void productInit() {
        if (productEntityRepo.count() == 0) {

            productEntityRepo
                    .saveAll(gson.fromJson(fetchProducts()
                                    .getBody(), ProductsJSON.class)
                            .getProducts()
                            .stream()
                            .map(productJson -> modelMapper
                                    .map(productJson, ProductEntity.class))
                            .collect(Collectors.toList()));
        }
    }

    private ResponseEntity<String> fetchProducts() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange("https://dummyjson.com/products", HttpMethod.GET, requestEntity, String.class);
    }

}
