package com.company.project.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.project.repository.OrderItemRepository;
import com.company.project.service.interfaces.OrderItemService;
import com.company.project.entity.OrderItem;
import org.springframework.data.domain.*;

@Service(value = "service_orders_item")
public class OrderItemServiceImp implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemServiceImp(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    // Orders Class is our entity
    public List<OrderItem> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir) {
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
        Page<OrderItem> page = orderItemRepository.findAll(pageable);
        List<OrderItem> orderItemList = page.getContent();
        return orderItemList;
    }

    @Override
    public OrderItem createOrdersItem(OrderItem orderItem) throws Exception {
        return null;
    }

    @Override
    public List<OrderItem> createOrdersItems(List<OrderItem> orderItemList) throws Exception {
        return null;
    }

    @Override
    public OrderItem readOrdersItem(Long id) throws Exception {
        return null;
    }

    @Override
    public List<OrderItem> readOrdersItems() {
        return null;
    }

    @Override
    public OrderItem updateOrdersItem(Long id, OrderItem orderItem) throws Exception {
        return null;
    }

    @Override
    public String deleteOrdersItem(Long id) throws Exception {
        return null;
    }

    @Override
    public OrderItem patchOrdersItem(Long id, OrderItem orderItem) throws Exception {
        return null;
    }

}
