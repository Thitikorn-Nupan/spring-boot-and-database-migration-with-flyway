package com.ttknp.understandflyway.repositories;

import com.ttknp.understandflyway.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
