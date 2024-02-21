package com.company.project.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.project.domain.Product;
import com.company.project.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.util.ArrayList;
import java.util.List;

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

    public List<Product> pagination(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Product> page = productRepository.findAll(pageable);
        List<Product> productList = page.getContent();
        return productList;
    }

    public List<Product> sortingSingle(String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        List<Product> productList = productRepository.findAll(sort);
        return productList;
    }

    public List<Product> sortingDouble(String sortByField1, String sortByField2, String sortDir) {
        Sort sortField1 = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortByField1).ascending()
                : Sort.by(sortByField1).descending();
        Sort sortField2 = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortByField2).ascending()
                : Sort.by(sortByField2).descending();
        Sort groupSort = sortField1.and(sortField2);
        List<Product> productList = productRepository.findAll(groupSort);
        return productList;
    }

    public List<Product> sortingMultiple(String[] sortBy, String sortDir) {
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < sortBy.length; i++) {
            Order order;
            if (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) {
                order = new Order(Sort.Direction.ASC, sortBy[i]);
            } else {
                order = new Order(Sort.Direction.DESC, sortBy[i]);
            }
            orderList.add(order);
        }

        Sort groupSort = Sort.by(orderList);

        List<Product> productList = productRepository.findAll(groupSort);

        return productList;
    }

    public List<Product> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir) {
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < sortBy.length; i++) {
            Order order;
            if (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) {
                order = new Order(Sort.Direction.ASC, sortBy[i]);
            } else {
                order = new Order(Sort.Direction.DESC, sortBy[i]);
            }
            orderList.add(order);
        }
        Sort sort = Sort.by(orderList);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Product> page = productRepository.findAll(pageable);
        List<Product> productList = page.getContent();
        return productList;
    }

}
