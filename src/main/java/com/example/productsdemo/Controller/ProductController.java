package com.example.productsdemo.Controller;

import com.example.productsdemo.Entity.ProductEntity;
import com.example.productsdemo.Entity.UserEntity;
import com.example.productsdemo.Repository.ProductEntityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.example.productsdemo.Consts.Globals.GLOBAL_FRONTEND_URL;
import static com.example.productsdemo.Consts.Globals.IS_USER_LOGGED;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = GLOBAL_FRONTEND_URL)
@RequestMapping("/product")
public class ProductController {

    private final ProductEntityRepo productEntityRepo;

    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts() {
        if (!IS_USER_LOGGED) {
            return new ResponseEntity<>("Please login.", HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(productEntityRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getAllProducts(@RequestParam Long id) {
        if (!IS_USER_LOGGED) {
            return new ResponseEntity<>("Please login.", HttpStatus.FORBIDDEN);
        }
        Optional<ProductEntity> byId = productEntityRepo.findById(id);
        return byId.map(productEntity -> new ResponseEntity<>(productEntity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add-product")
    public ResponseEntity<String> addProduct(@RequestBody ProductEntity productEntity) {
        if (!IS_USER_LOGGED) {
            return new ResponseEntity<>("Please login.", HttpStatus.FORBIDDEN);
        }

        productEntityRepo.save(productEntity);
        return new ResponseEntity<>("Product added.", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById(@RequestParam Long id) {
        if (!IS_USER_LOGGED) {
            return new ResponseEntity<>("Please login.", HttpStatus.FORBIDDEN);
        }

        if (!productEntityRepo.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        productEntityRepo.deleteById(id);
        return new ResponseEntity<>("Product deleted.", HttpStatus.ACCEPTED);
    }
}
