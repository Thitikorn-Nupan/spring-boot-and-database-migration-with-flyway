package com.ttknp.understandflyway.dto;

import com.ttknp.understandflyway.entities.Product;
import com.ttknp.understandflyway.repositories.ProductRepository;
import com.ttknp.understandflyway.services.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductDTOCommonService implements CommonService<Product> {

    private final ProductRepository productRepositoryCommon;

    @Autowired
    public ProductDTOCommonService(ProductRepository productRepositoryCommon) {
        this.productRepositoryCommon = productRepositoryCommon;
    }

    @Override
    public Iterable<Product> retrieveAllModels() {
        if (productRepositoryCommon.count() == 0) { // select count(*) from products p1_0
            return null;
        } else {
            return productRepositoryCommon.findAll();
        }
    }

    @Override
    public <U> Optional<Product> retrieveModel(U key) {
        Long id = Long.parseLong(key.toString());
        Optional<Product> product = productRepositoryCommon.findById(id);
        return product;
    }

    @Override
    public Boolean createModel(Product model) {
        return productRepositoryCommon.save(model).getId() != null;
    }

    @Override
    public <U> Boolean updateModel(Product model, U key) {
        Long id = Long.parseLong(key.toString());
        Optional<Product> searchProduct = productRepositoryCommon.findById(id);
        if (searchProduct.isPresent()) {
            searchProduct.get().setName(model.getName());
            searchProduct.get().setPrice(model.getPrice());
            searchProduct.get().setQuantity(model.getQuantity());
            searchProduct.get().setSku(model.getSku());
            searchProduct.get().setActive(model.getActive());
            return productRepositoryCommon.save(searchProduct.get()).getId() != null;
        }
        return false;
    }

    @Override
    public <U> Boolean deleteModel(U key) {
        Long id = Long.parseLong(key.toString());
        return productRepositoryCommon.findById(id).map((p)-> {
            productRepositoryCommon.delete(p);
            return true;
        }).orElse(false);
    }
}
