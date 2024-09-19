package com.attractor.onlineshop.repositories;

import com.attractor.onlineshop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(long id);
    List<Product> findByName(String name);
    List<Product> findByDescription(String description);
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal lowerPrice, BigDecimal upperPrice);
    List<Product> findByBrandName(String brandName);
    List<Product> findByCategoryName(String categoryName);
}
