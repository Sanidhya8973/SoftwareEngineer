package com.company.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import com.company.project.model.OrdersItem;
import com.company.project.repository.OrdersItemRepository;

public class OrdersItemService {

	@Autowired
	private OrdersItemRepository ordersItemRepository;

	public long count() {
		return ordersItemRepository.count();
	}

	public boolean existsById(Long id) {
		return ordersItemRepository.existsById(id);
	}

	public OrdersItem findById(Long id) {
		return ordersItemRepository.findById(id).get();
	}

	public List<OrdersItem> findAll() {
		return ordersItemRepository.findAll();
	}

	public List<OrdersItem> findAllById(List<Long> ordersItemIdList) {
		return ordersItemRepository.findAllById(ordersItemIdList);
	}

	public void save(OrdersItem ordersItem) {
		ordersItemRepository.save(ordersItem);
	}

	public void saveAll(List<OrdersItem> ordersItemList) {
		ordersItemRepository.saveAll(ordersItemList);
	}

	public void update(Long id, OrdersItem newOrdersItem) {
		OrdersItem oldOrdersItem = ordersItemRepository.findById(id).get();
		if (oldOrdersItem.getId() == newOrdersItem.getId()) {
			ordersItemRepository.save(newOrdersItem);
		}
	}

	public void deleteById(Long id) {
		ordersItemRepository.deleteById(id);
	}

	public void delete(OrdersItem ordersItem) {
		ordersItemRepository.delete(ordersItem);
	}

	public void deleteAll() {
		ordersItemRepository.deleteAll();
	}

	public void deleteAll(List<OrdersItem> ordersItemList) {
		ordersItemRepository.deleteAll(ordersItemList);
	}

	public void deleteAllById(List<Long> ordersItemIdList) {
		ordersItemRepository.deleteAllById(ordersItemIdList);
	}

	// Orders Class is our entity
	public List<OrdersItem> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir) {
		// Order Class is from org.springframework.data.domain.Sort.Order;
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
		Page<OrdersItem> page = ordersItemRepository.findAll(pageable);
		List<OrdersItem> ordersItemList = page.getContent();
		return ordersItemList;
	}

}
