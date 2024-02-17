package com.company.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.project.repository.ProductRepository;
import com.company.project.entity.ProductEntity;

@Service(value = "service_product")
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public long count() {
        return productRepository.count();
    }

    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }

    public ProductEntity findById(Long id) {
        return productRepository.findById(id).get();
    }

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    public List<ProductEntity> findAllById(List<Long> productIdList) {
        return productRepository.findAllById(productIdList);
    }

    public void save(ProductEntity productEntity) {
        productRepository.save(productEntity);
    }

    public void saveAll(List<ProductEntity> productEntityList) {
        productRepository.saveAll(productEntityList);
    }

    public void update(Long id, ProductEntity newProductEntity) {
        ProductEntity oldProductEntity = productRepository.findById(id).get();
        if (oldProductEntity.getId() == newProductEntity.getId()) {
            productRepository.save(newProductEntity);
        }
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void delete(ProductEntity productEntity) {
        productRepository.delete(productEntity);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

    public void deleteAll(List<ProductEntity> productEntityList) {
        productRepository.deleteAll(productEntityList);
    }

    public void deleteAllById(List<Long> productIdList) {
        productRepository.deleteAllById(productIdList);
    }

}
