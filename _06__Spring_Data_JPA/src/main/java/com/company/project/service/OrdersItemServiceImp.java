package com.company.project.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.project.repository.OrdersItemRepository;
import com.company.project.service.interfaces.OrdersItemService;
import com.company.project.model.OrdersItem;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Order;

@Service(value = "service_orders_item")
public class OrdersItemServiceImp implements OrdersItemService {

    private final OrdersItemRepository ordersItemRepository;

    @Autowired
    public OrdersItemServiceImp(OrdersItemRepository ordersItemRepository) {
        this.ordersItemRepository = ordersItemRepository;
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

    @Override
    public OrdersItem createOrdersItem(OrdersItem ordersItem) throws Exception {
        return null;
    }

    @Override
    public List<OrdersItem> createOrdersItems(List<OrdersItem> ordersItemList) throws Exception {
        return null;
    }

    @Override
    public OrdersItem readOrdersItem(Long id) throws Exception {
        return null;
    }

    @Override
    public List<OrdersItem> readOrdersItems() {
        return null;
    }

    @Override
    public OrdersItem updateOrdersItem(Long id, OrdersItem ordersItem) throws Exception {
        return null;
    }

    @Override
    public String deleteOrdersItem(Long id) throws Exception {
        return null;
    }

    @Override
    public OrdersItem patchOrdersItem(Long id, OrdersItem ordersItem) throws Exception {
        return null;
    }

}
