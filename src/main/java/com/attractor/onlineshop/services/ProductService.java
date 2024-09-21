package com.attractor.onlineshop.services;

import com.attractor.onlineshop.entities.Product;
import com.attractor.onlineshop.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService extends GenericService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findByName(int page, int size, String name) {
        Sort sort = Sort.by(
                Sort.Order.asc(name)
        );

        Pageable pageable = PageRequest.of(page, size, sort);

        return repository.findByName(name, pageable);
    }

    public List<Product> findByDescription(int page, int size, String description) {
        Sort sort = Sort.by(
                Sort.Order.asc(description)
        );

        Pageable pageable = PageRequest.of(page, size, sort);

        return repository.findByDescription(description, pageable);
    }

    public List<Product> findByPrice(BigDecimal price) {
        return repository.findByPrice(price);
    }

    public List<Product> findByPriceBetween(BigDecimal lower, BigDecimal upper) {
        return repository.findByPriceBetween(lower, upper);
    }

    public List<Product> findByBrandName(int page, int size, String brandName) {
        Sort sort = Sort.by(
                Sort.Order.asc(brandName)
        );

        Pageable pageable = PageRequest.of(page, size, sort);

        return repository.findByBrandName(brandName, pageable);
    }

    public List<Product> findByCategoryName(int page, int size, String categoryName) {
        Sort sort = Sort.by(
                Sort.Order.asc(categoryName)
        );

        Pageable pageable = PageRequest.of(page, size, sort);

        return repository.findByCategoryName(categoryName, pageable);
    }
}
