package com.ttknp.understandflyway.dto;

import com.ttknp.understandflyway.entities.Product;
import com.ttknp.understandflyway.repositories.ProductRepository;
import com.ttknp.understandflyway.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductDTO implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDTO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> retrieveAllProducts() {
        if (productRepository.count() == 0) { // select count(*) from products p1_0
            return null;
        } else {
            Iterable<Product> products = productRepository.findAll();
            System.out.println(products);
            return products;
        }
    }

    @Override
    public Optional<Product> retrieveProduct(long id) {
        Optional<Product> product;
        product = productRepository.findById(id);
        System.out.println(product);
        return product;
    }

    @Override
    public Boolean createProduct(Product product) {
        return productRepository.save(product).getId() != null;
    }

    @Override
    public Boolean updateProduct(Product product, long id) {
        Optional<Product> searchProduct = productRepository.findById(id);
        if (searchProduct.isPresent()) {
            searchProduct.get().setName(product.getName());
            searchProduct.get().setPrice(product.getPrice());
            searchProduct.get().setQuantity(product.getQuantity());
            searchProduct.get().setSku(product.getSku());
            searchProduct.get().setActive(product.getActive());
            return productRepository.save(searchProduct.get()).getId() != null;
        }
        return false;
    }

    @Override
    public Boolean deleteProduct(long id) {
        return productRepository.findById(id).map((p)-> {
            productRepository.delete(p);
            return true;
        }).orElse(false);
    }
}
