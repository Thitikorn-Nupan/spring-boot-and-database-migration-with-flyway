package com.ttknp.understandflyway.services;

import com.ttknp.understandflyway.entities.Product;

import java.util.Optional;

public interface ProductService {
     Iterable<Product> retrieveAllProducts();
     Optional<Product> retrieveProduct(long id);
     Boolean createProduct(Product product);
     Boolean updateProduct(Product product, long id);
     Boolean deleteProduct(long id);
}
