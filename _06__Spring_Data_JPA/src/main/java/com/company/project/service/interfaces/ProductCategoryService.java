package com.company.project.service.interfaces;

import java.util.List;

import com.company.project.model.ProductCategory;

public interface ProductCategoryService {

    public abstract List<ProductCategory> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir);

    public abstract ProductCategory createProductCategory(ProductCategory productCategory) throws Exception;

    public abstract List<ProductCategory> createProductCategories(List<ProductCategory> productCategoryList) throws Exception;

    public abstract ProductCategory readProductCategory(Long id) throws Exception;

    public abstract List<ProductCategory> readProductCategories();

    public abstract ProductCategory updateProductCategory(Long id, ProductCategory productCategory) throws Exception;

    public abstract String deleteProductCategory(Long id) throws Exception;

    public abstract ProductCategory patchProductCategory(Long id, ProductCategory productCategory) throws Exception;

}
