package com.example.homework.service;

import com.example.homework.entity.Product;
import com.example.homework.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    public Page<Product> getProductsByPattern(String pattern, PageRequest of) {
        return productRepository.searchProductsByNameOrDescription(pattern, of);
    }

    public List<Product> getAllProductsByPriceAscending() {
        return productRepository.findAllOrderByPriceAsc();
    }
    public List<Product> getAllProductsByPriceDescending() {
        return productRepository.findAllOrderByPriceDesc();
    }

    public List<Product> getProductsByBrandName(Long brandId) {
        return productRepository.findProductsByBrand_Id(brandId);
    }

    public List<Product> getProductsByCategoryName(Long categoryId) {
        return productRepository.findProductsByCategory_Id(categoryId);
    }

    public List<Product> getProductsByPriceRange(BigDecimal lower, BigDecimal upper) {
        return productRepository.searchProductsByPriceRange(lower, upper);
    }
}
