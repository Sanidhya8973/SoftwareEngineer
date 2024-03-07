package com.company.project.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.project.repository.ProductRepository;
import com.company.project.service.interfaces.ProductService;
import com.company.project.model.Product;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Order;

@Service(value = "service_product")
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
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

    @Override
    public Product createProduct(Product product) throws Exception {
        return null;
    }

    @Override
    public List<Product> createProducts(List<Product> productList) throws Exception {
        return null;
    }

    @Override
    public Product readProduct(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Product> readProducts() {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) throws Exception {
        return null;
    }

    @Override
    public String deleteProduct(Long id) throws Exception {
        return null;
    }

    @Override
    public Product patchProduct(Long id, Product product) throws Exception {
        return null;
    }

}

/*

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

 */