package com.company.project.service.interfaces;

import java.util.List;

import com.company.project.model.Product;

public interface ProductService {

    public abstract List<Product> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir);

    public abstract Product createProduct(Product product) throws Exception;

    public abstract List<Product> createProducts(List<Product> productList) throws Exception;

    public abstract Product readProduct(Long id) throws Exception;

    public abstract List<Product> readProducts();

    public abstract Product updateProduct(Long id, Product product) throws Exception;

    public abstract String deleteProduct(Long id) throws Exception;

    public abstract Product patchProduct(Long id, Product product) throws Exception;

}
