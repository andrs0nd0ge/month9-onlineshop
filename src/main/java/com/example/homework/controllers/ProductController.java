package com.example.homework.controllers;

import com.example.homework.entity.Brand;
import com.example.homework.entity.Category;
import com.example.homework.entity.Product;
import com.example.homework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return this.productService.getById(id);
    }

    @GetMapping("/{pattern}")
    public List<Product> getProductByName(@PathVariable String pattern) {
        return this.productService.getProductsByPattern(pattern);
    }

    @GetMapping("/{brand}")
    public List<Product> getProductsByBrands(@PathVariable Brand brand) {
        return this.productService.getProductsByBrandName(brand.getId());
    }

    @GetMapping("/{category}")
    public List<Product> getProductsByCategories(@PathVariable Category category){
        return this.productService.getProductsByCategoryName(category.getId());
    }
}
