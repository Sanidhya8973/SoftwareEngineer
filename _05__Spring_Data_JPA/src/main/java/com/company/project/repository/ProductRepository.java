package com.company.project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.company.project.entity.ProductEntity;

@Repository(value = "repository_product")
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    // spring framework does the magic...
}
