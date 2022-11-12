package com.example.homework.controllers;

import com.example.homework.entity.Category;
import com.example.homework.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return this.categoryService.getById(id);
    }

    @GetMapping("/{name}")
    public List<Category> getCategoryByName(@PathVariable String name) {
        return this.categoryService.getByNamePattern(name);
    }
}
