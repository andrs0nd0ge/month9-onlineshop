package com.example.homework.service;

import com.example.homework.entity.Category;
import com.example.homework.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> getById(Long id) {
        return this.categoryRepository.findById(id);
    }

    public List<Category> getByNamePattern(String pattern) {
        return this.categoryRepository.searchCategoriesByNameIgnoreCase(pattern);
    }
}
