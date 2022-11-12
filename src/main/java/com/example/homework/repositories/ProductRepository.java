package com.example.homework.repositories;

import com.example.homework.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("SELECT p from Product as p " +
            "where p.name like (:pattern) or " +
            "p.description like (:pattern)")
    List<Product> searchProductsByNameOrDescription(@Param("pattern") String pattern);
    List<Product> findProductsByBrand_IdContainingIgnoreCase(Long brandId);
    List<Product> findProductsByCategory_IdContainingIgnoreCase(Long categoryId);
    @Query("select p from Product as p " +
            "where p.price between (:lower) and (:upper)")
    List<Product> searchProductsByPriceRangeOrderByPriceAsc(@Param("lower") BigDecimal lower, @Param("upper") BigDecimal upper);
    List<Product> findAllByPriceOrderByPriceAsc(BigDecimal price);
    List<Product> findAllByPriceOrderByPriceDesc(BigDecimal price);
}
