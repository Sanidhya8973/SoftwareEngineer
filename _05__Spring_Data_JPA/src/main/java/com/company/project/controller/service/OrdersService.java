package com.company.project.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.company.project.domain.Orders;
import com.company.project.repository.OrdersRepository;

@Service(value = "service_order")
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepositroy;

	public long count() {
		return ordersRepositroy.count();
	}

	public boolean existsById(Long id) {
		return ordersRepositroy.existsById(id);
	}

	public Orders findById(Long id) {
		return ordersRepositroy.findById(id).get();
	}

	public List<Orders> findAll() {
		return ordersRepositroy.findAll();
	}

	public List<Orders> findAllById(List<Long> orderIdList) {
		return ordersRepositroy.findAllById(orderIdList);
	}

	public void save(Orders order) {
		ordersRepositroy.save(order);
	}

	public void saveAll(List<Orders> orderList) {
		ordersRepositroy.saveAll(orderList);
	}

	public void update(Long id, Orders newOrder) {
		Orders oldOrder = ordersRepositroy.findById(id).get();
		if (oldOrder.getId() == newOrder.getId()) {
			ordersRepositroy.save(newOrder);
		}
	}

	public void deleteById(Long id) {
		ordersRepositroy.deleteById(id);
	}

	public void delete(Orders order) {
		ordersRepositroy.delete(order);
	}

	public void deleteAll() {
		ordersRepositroy.deleteAll();
	}

	public void deleteAll(List<Orders> orderList) {
		ordersRepositroy.deleteAll(orderList);
	}

	public void deleteAllById(List<Long> orderIdList) {
		ordersRepositroy.deleteAllById(orderIdList);
	}

	// Orders Class is our entity
	public List<Orders> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir) {
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
		Page<Orders> page = ordersRepositroy.findAll(pageable);
		List<Orders> myOrderList = page.getContent();
		return myOrderList;
	}

}
