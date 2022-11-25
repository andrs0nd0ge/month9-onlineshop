package com.example.homework.controllers;

import com.example.homework.entity.Brand;
import com.example.homework.entity.Category;
import com.example.homework.entity.Product;
import com.example.homework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        return productService.getById(id);
    }

    @GetMapping("name")
    public Page<Product> getProductByName(@RequestParam String pattern,
                                          @RequestParam Optional<Integer> page) {
        pattern += "";
        return productService.getProductsByPattern(pattern, PageRequest.of(page.orElse(0), 5));
    }

    @GetMapping("brand/{brand}")
    public List<Product> getProductsByBrands(@PathVariable Brand brand) {
        return productService.getProductsByBrandName(brand.getId());
    }

    @GetMapping("category/{category}")
    public List<Product> getProductsByCategories(@PathVariable Category category){
        return productService.getProductsByCategoryName(category.getId());
    }

    @GetMapping("price_range")
    public List<Product> getProductsByPriceRange(@RequestParam(value = "lower", required = false, defaultValue = "0") BigDecimal lower,
                                                 @RequestParam(value = "upper", required = false, defaultValue = "100") BigDecimal upper){
        return this.productService.getProductsByPriceRange(lower, upper);
    }

    @GetMapping("order_asc")
    public List<Product> getProductsByPriceOrderAsc(){
        return productService.getAllProductsByPriceAscending();
    }

    @GetMapping("order_desc")
    public List<Product> getProductsByPriceOrderDesc() {
        return productService.getAllProductsByPriceDescending();
    }
}
