package com.example.productsdemo.init;

import com.example.productsdemo.Entity.ProductEntity;
import com.example.productsdemo.Repository.ProductEntityRepo;
import com.example.productsdemo.models.ProductJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductInit {

    private final ProductEntityRepo productEntityRepo;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @PostConstruct
    public void productInit() throws FileNotFoundException {
        if (productEntityRepo.count() == 0) {
            System.out.println("we are here ");
            FileReader reader = new FileReader("com/example/productsdemo/data/products.json");
            Type productListType = new TypeToken<List<ProductJson>>() {}.getType();
            List<ProductJson> products = gson.fromJson(reader, productListType);

            productEntityRepo
                    .saveAll(products
                            .stream()
                            .map(productJson -> modelMapper
                                    .map(productJson, ProductEntity.class))
                            .collect(Collectors.toList()));
        }

    }

}
