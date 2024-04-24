package com.example.productsdemo.Repository;

import com.example.productsdemo.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepo extends JpaRepository<ProductEntity, Long> {


}
