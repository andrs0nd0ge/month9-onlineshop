package com.example.homework.service;

import com.example.homework.entity.Product;
import com.example.homework.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> getById(Long id) {
        return this.productRepository.findById(id);
    }

    public List<Product> getProductsByPattern(String pattern) {
        return this.productRepository.searchProductsByNameOrDescription(pattern);
    }

    public List<Product> getAllProductsByPriceAscending() {
        return this.productRepository.findAllOrderByPriceAsc();
    }
    public List<Product> getAllProductsByPriceDescending() {
        return this.productRepository.findAllOrderByPriceDesc();
    }

    public List<Product> getProductsByBrandName(Long brandId) {
        return this.productRepository.findProductsByBrand_Id(brandId);
    }

    public List<Product> getProductsByCategoryName(Long categoryId) {
        return this.productRepository.findProductsByCategory_Id(categoryId);
    }

    public List<Product> getProductsByPriceRange(BigDecimal lower, BigDecimal upper) {
        return this.productRepository.searchProductsByPriceRange(lower, upper);
    }
}
