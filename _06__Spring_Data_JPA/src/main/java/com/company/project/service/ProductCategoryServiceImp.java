package com.company.project.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.project.repository.ProductCategoryRepository;
import com.company.project.service.interfaces.ProductCategoryService;
import com.company.project.entity.ProductCategory;
import org.springframework.data.domain.*;

@Service(value = "service_product_category")
public class ProductCategoryServiceImp implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryServiceImp(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<ProductCategory> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir) {
        List<Sort.Order> orderList = new ArrayList<>();
        for (int i = 0; i < sortBy.length; i++) {
            Sort.Order order;
            if (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) {
                order = new Sort.Order(Sort.Direction.ASC, sortBy[i]);
            } else {
                order = new Sort.Order(Sort.Direction.DESC, sortBy[i]);
            }
            orderList.add(order);
        }
        Sort sort = Sort.by(orderList);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<ProductCategory> page = productCategoryRepository.findAll(pageable);
        List<ProductCategory> productCategoryList = page.getContent();
        return productCategoryList;
    }

    @Override
    public ProductCategory createProductCategory(ProductCategory productCategory) throws Exception {
        return null;
    }

    @Override
    public List<ProductCategory> createProductCategories(List<ProductCategory> productCategoryList) throws Exception {
        return null;
    }

    @Override
    public ProductCategory readProductCategory(Long id) throws Exception {
        return null;
    }

    @Override
    public List<ProductCategory> readProductCategories() {
        return null;
    }

    @Override
    public ProductCategory updateProductCategory(Long id, ProductCategory productCategory) throws Exception {
        return null;
    }

    @Override
    public String deleteProductCategory(Long id) throws Exception {
        return null;
    }

    @Override
    public ProductCategory patchProductCategory(Long id, ProductCategory productCategory) throws Exception {
        return null;
    }

}
