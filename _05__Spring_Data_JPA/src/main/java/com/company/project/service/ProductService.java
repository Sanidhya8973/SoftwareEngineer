package com.company.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.project.repository.ProductRepository;
import com.company.project.entity.Product;

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

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllById(List<Long> productIdList) {
        return productRepository.findAllById(productIdList);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void saveAll(List<Product> productList) {
        productRepository.saveAll(productList);
    }

    public void update(Long id, Product newProduct) {
        Product oldProduct = productRepository.findById(id).get();
        if (oldProduct.getId() == newProduct.getId()) {
            productRepository.save(newProduct);
        }
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

    public void deleteAll(List<Product> productList) {
        productRepository.deleteAll(productList);
    }

    public void deleteAllById(List<Long> productIdList) {
        productRepository.deleteAllById(productIdList);
    }

}
