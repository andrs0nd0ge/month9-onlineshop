package com.example.homework.repositories;

import com.example.homework.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("SELECT p from Product as p " +
            "where lower(p.name) like concat('%', lower(:pattern), '%') or " +
            "lower(p.description) like concat('%', lower(:pattern), '%')")
    Page<Product> searchProductsByNameOrDescription(@Param("pattern") String pattern, Pageable pageable);
    List<Product> findProductsByBrand_Id(Long brandId);
    List<Product> findProductsByCategory_Id(Long categoryId);
    @Query("select p from Product as p " +
            "where p.price between (:lower) and (:upper)" +
            "order by p.price asc")
    List<Product> searchProductsByPriceRange(@Param("lower") BigDecimal lower, @Param("upper") BigDecimal upper);
    @Query("select p from Product as p " +
            "order by p.price asc")
    List<Product> findAllOrderByPriceAsc();

    @Query("select p from Product as p " +
            "order by p.price desc")
    List<Product> findAllOrderByPriceDesc();
}
