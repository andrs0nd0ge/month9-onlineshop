package com.example.homework.service;

import com.example.homework.entity.Product;
import com.example.homework.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> getById(Long id) {
        return this.productRepository.findById(id);
    }
}
