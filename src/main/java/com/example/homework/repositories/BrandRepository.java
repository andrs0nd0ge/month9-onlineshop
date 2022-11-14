package com.example.homework.repositories;

import com.example.homework.entity.Brand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {
    @Query("SELECT b from Brand as b " +
            "where b.name like (:pattern)")
    List<Brand> searchBrandsByName(@Param("pattern") String pattern);
}
