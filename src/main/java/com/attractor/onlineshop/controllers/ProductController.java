package com.attractor.onlineshop.controllers;

import com.attractor.onlineshop.entities.Product;
import com.attractor.onlineshop.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping(params = {"page", "size", "name"})
    public ResponseEntity<List<Product>> findByName(@RequestParam int page,
                                                    @RequestParam int pageSize,
                                                    @RequestParam String name) {
        List<Product> products = service.findByName(page, pageSize, name);

        return service.returnResponseForList(products);
    }

    @GetMapping(params = {"page", "size", "desc"})
    public ResponseEntity<List<Product>> findByDescription(@RequestParam int page,
                                                           @RequestParam int pageSize,
                                                           @RequestParam String description) {
        List<Product> products = service.findByDescription(page, pageSize, description);

        return service.returnResponseForList(products);
    }

    @GetMapping(params = "price")
    public ResponseEntity<List<Product>> findByPrice(@RequestParam BigDecimal price) {
        List<Product> products = service.findByPrice(price);

        return service.returnResponseForList(products);
    }

    @GetMapping(params = {"lower", "upper"})
    public ResponseEntity<List<Product>> findByPriceBetween(@RequestParam BigDecimal lower,
                                                            @RequestParam BigDecimal upper) {
        List<Product> products = service.findByPriceBetween(lower, upper);

        return service.returnResponseForList(products);
    }

    @GetMapping(params = {"page", "size", "brand"})
    public ResponseEntity<List<Product>> findByBrandName(@RequestParam int page,
                                                         @RequestParam int pageSize,
                                                         @RequestParam String brandName) {
        List<Product> products = service.findByBrandName(page, pageSize, brandName);

        return service.returnResponseForList(products);
    }

    @GetMapping(params = {"page", "size", "category"})
    public ResponseEntity<List<Product>> findByCategoryName(@RequestParam int page,
                                                            @RequestParam int pageSize,
                                                            @RequestParam String categoryName) {
        List<Product> products = service.findByCategoryName(page, pageSize, categoryName);

        return service.returnResponseForList(products);
    }
}
