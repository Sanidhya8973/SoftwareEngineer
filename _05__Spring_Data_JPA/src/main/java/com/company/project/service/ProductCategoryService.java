package com.company.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import com.company.project.domain.ProductCategory;
import com.company.project.repository.ProductCategoryRepository;

public class ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	public long count() {
		return productCategoryRepository.count();
	}

	public boolean existsById(Long id) {
		return productCategoryRepository.existsById(id);
	}

	public ProductCategory findById(Long id) {
		return productCategoryRepository.findById(id).get();
	}

	public List<ProductCategory> findAll() {
		return productCategoryRepository.findAll();
	}

	public List<ProductCategory> findAllById(List<Long> productCategoryIdList) {
		return productCategoryRepository.findAllById(productCategoryIdList);
	}

	public void save(ProductCategory productCategory) {
		productCategoryRepository.save(productCategory);
	}

	public void saveAll(List<ProductCategory> productCategoryList) {
		productCategoryRepository.saveAll(productCategoryList);
	}

	public void update(Long id, ProductCategory newProductCategory) {
		ProductCategory oldProductCategory = productCategoryRepository.findById(id).get();
		if (oldProductCategory.getId() == newProductCategory.getId()) {
			productCategoryRepository.save(newProductCategory);
		}
	}

	public void deleteById(Long id) {
		productCategoryRepository.deleteById(id);
	}

	public void delete(ProductCategory productCategory) {
		productCategoryRepository.delete(productCategory);
	}

	public void deleteAll() {
		productCategoryRepository.deleteAll();
	}

	public void deleteAll(List<ProductCategory> productCategoryList) {
		productCategoryRepository.deleteAll(productCategoryList);
	}

	public void deleteAllById(List<Long> productCategoryIdList) {
		productCategoryRepository.deleteAllById(productCategoryIdList);
	}

	public List<ProductCategory> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir) {
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
		Page<ProductCategory> page = productCategoryRepository.findAll(pageable);
		List<ProductCategory> productCategoryList = page.getContent();
		return productCategoryList;
	}

}
