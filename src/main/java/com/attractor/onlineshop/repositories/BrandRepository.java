package com.attractor.onlineshop.repositories;

import com.attractor.onlineshop.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findById(long id);
    Brand findByName(String name);
}
