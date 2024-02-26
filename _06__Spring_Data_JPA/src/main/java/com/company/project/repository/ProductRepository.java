package com.company.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.company.project.model.Product;

@Repository(value = "repository_product")
public interface ProductRepository extends JpaRepository<Product, Long> {

}
