package com.example.homework.service;

import com.example.homework.entity.Brand;
import com.example.homework.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public Optional<Brand> getById(Long id) {
        return this.brandRepository.findById(id);
    }

    public List<Brand> getByNamePattern(String pattern) {
        return this.brandRepository.searchBrandsByName(pattern);
    }
}
