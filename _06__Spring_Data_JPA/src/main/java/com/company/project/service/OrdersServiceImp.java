package com.company.project.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.project.repository.OrdersRepository;
import com.company.project.service.interfaces.OrdersService;
import com.company.project.model.Orders;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Order;

@Service(value = "service_orders")
public class OrdersServiceImp implements OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersServiceImp(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
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
        Page<Orders> page = ordersRepository.findAll(pageable);
        List<Orders> myOrderList = page.getContent();
        return myOrderList;
    }

    @Override
    public Orders createOrders(Orders orders) throws Exception {
        return null;
    }

    @Override
    public List<Orders> createAllOrders(List<Orders> ordersList) throws Exception {
        return null;
    }

    @Override
    public Orders readOrders(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Orders> readAllOrders() {
        return null;
    }

    @Override
    public Orders updateOrders(Long id, Orders orders) throws Exception {
        return null;
    }

    @Override
    public String deleteOrders(Long id) throws Exception {
        return null;
    }

    @Override
    public Orders patchOrders(Long id, Orders orders) throws Exception {
        return null;
    }

}
