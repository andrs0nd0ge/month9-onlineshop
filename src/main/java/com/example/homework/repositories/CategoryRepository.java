package com.example.homework.repositories;

import com.example.homework.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    @Query("SELECT c from Category as c " +
            "where lower(c.name) like concat('%', lower(:pattern), '%')")
    List<Category> searchCategoriesByNameIgnoreCase(@Param("pattern") String pattern);
}
