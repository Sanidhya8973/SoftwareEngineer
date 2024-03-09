package com.company.project.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.project.repository.OrderRepository;
import com.company.project.service.interfaces.OrderService;
import com.company.project.entity.Order;
import org.springframework.data.domain.*;

@Service(value = "service_orders")
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Orders Class is our entity
    public List<Order> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir) {
        // Order Class is from org.springframework.data.domain.Sort.Order;
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
        Page<Order> page = orderRepository.findAll(pageable);
        List<Order> myOrderList = page.getContent();
        return myOrderList;
    }

    @Override
    public Order createOrders(Order order) throws Exception {
        return null;
    }

    @Override
    public List<Order> createAllOrders(List<Order> orderList) throws Exception {
        return null;
    }

    @Override
    public Order readOrders(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Order> readAllOrders() {
        return null;
    }

    @Override
    public Order updateOrders(Long id, Order order) throws Exception {
        return null;
    }

    @Override
    public String deleteOrders(Long id) throws Exception {
        return null;
    }

    @Override
    public Order patchOrders(Long id, Order order) throws Exception {
        return null;
    }

}
