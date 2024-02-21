package com.company.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.project.domain.ProductCategory;

@Repository(value = "repository_product_category_repository")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
