package com.attractor.onlineshop.services;

import com.attractor.onlineshop.entities.Product;
import com.attractor.onlineshop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService extends GenericService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findByName(String name) {
        return repository.findByName(name);
    }

    public List<Product> findByDescription(String description) {
        return repository.findByName(description);
    }

    public List<Product> findByPrice(BigDecimal price) {
        return repository.findByPrice(price);
    }

    public List<Product> findByPriceBetween(BigDecimal lower, BigDecimal upper) {
        return repository.findByPriceBetween(lower, upper);
    }

    public List<Product> findByBrandName(String brandName) {
        return repository.findByBrandName(brandName);
    }

    public List<Product> findByCategoryName(String categoryName) {
        return repository.findByCategoryName(categoryName);
    }
}
