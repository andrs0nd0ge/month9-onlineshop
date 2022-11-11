package com.example.homework.controllers;

import com.example.homework.entity.Product;
import com.example.homework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return this.productService.getById(id);
    }
}
