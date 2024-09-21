package com.attractor.onlineshop.repositories;

import com.attractor.onlineshop.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(long id);
    List<Product> findByName(String name, Pageable pageable);
    List<Product> findByDescription(String description, Pageable pageable);
    @Query("select p " +
            "from Product as p " +
            "where p.price = :price")
    List<Product> findByPrice(BigDecimal price);
    @Query("select p " +
            "from Product as p " +
            "where p.price >= :lowerPrice and p.price <= :upperPrice")
    List<Product> findByPriceBetween(BigDecimal lowerPrice, BigDecimal upperPrice);
    List<Product> findByBrandName(String brandName, Pageable pageable);
    List<Product> findByCategoryName(String categoryName, Pageable pageable);
}
