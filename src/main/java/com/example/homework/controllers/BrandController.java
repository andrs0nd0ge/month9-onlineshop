package com.example.homework.controllers;

import com.example.homework.entity.Brand;
import com.example.homework.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController("/brand")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @GetMapping("/{id}")
    public Optional<Brand> getBrandById(@PathVariable Long id){
        return this.brandService.getById(id);
    }

    @GetMapping("/{name}")
    public List<Brand> getBrandByName(@PathVariable String name){
        return this.brandService.getByNamePattern(name);
    }
}
