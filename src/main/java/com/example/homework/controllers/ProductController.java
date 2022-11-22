package com.example.homework.controllers;

import com.example.homework.entity.Brand;
import com.example.homework.entity.Category;
import com.example.homework.entity.Product;
import com.example.homework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("id/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return this.productService.getById(id);
    }

    @GetMapping("name/{pattern}")
    public List<Product> getProductByName(@PathVariable String pattern) {
        return this.productService.getProductsByPattern(pattern);
    }

    @GetMapping("brand/{brand}")
    public List<Product> getProductsByBrands(@PathVariable Brand brand) {
        return this.productService.getProductsByBrandName(brand.getId());
    }

    @GetMapping("category/{category}")
    public List<Product> getProductsByCategories(@PathVariable Category category){
        return this.productService.getProductsByCategoryName(category.getId());
    }

    @GetMapping("price_range")
    public List<Product> getProductsByPriceRange(@RequestParam(value = "lower", required = false, defaultValue = "0") BigDecimal lower,
                                                 @RequestParam(value = "upper", required = false, defaultValue = "100") BigDecimal upper){
        return this.productService.getProductsByPriceRange(lower, upper);
    }

    @GetMapping("order_asc")
    public List<Product> getProductsByPriceOrderAsc(){
        return this.productService.getAllProductsByPriceAscending();
    }

    @GetMapping("order_desc")
    public List<Product> getProductsByPriceOrderDesc() {
        return this.productService.getAllProductsByPriceDescending();
    }
}
