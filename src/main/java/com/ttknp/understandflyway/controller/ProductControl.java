package com.ttknp.understandflyway.controller;

import com.ttknp.understandflyway.entities.Product;
import com.ttknp.understandflyway.repositories.ProductRepository;
import com.ttknp.understandflyway.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductControl {
    private final ProductService productService;

    @Autowired
    public ProductControl(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/server")
    public ResponseEntity<Product> server() {
        Product product = new Product();
        product.setId(1L);
        return ResponseEntity.ok(product);
    }

    @GetMapping(value = "/reads")
    public ResponseEntity<Iterable<Product>> reads() {
        return ResponseEntity.ok(productService.retrieveAllProducts());
    }

    @GetMapping(value = "/read")
    public ResponseEntity<Optional<Product>> read(@RequestParam long id) {
        return ResponseEntity.status(202).body(productService.retrieveProduct(id));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Boolean> create(@RequestBody Product product) {
        return ResponseEntity.status(201).body(productService.createProduct(product));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Boolean> update(@RequestBody Product product,@RequestParam long id) {
        return ResponseEntity.status(202).body(productService.updateProduct(product,id));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestParam long id) {
        return ResponseEntity.status(202).body(productService.deleteProduct(id));
    }


}
