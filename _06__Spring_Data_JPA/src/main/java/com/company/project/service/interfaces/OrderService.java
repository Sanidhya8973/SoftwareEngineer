package com.company.project.service.interfaces;

import java.util.List;

import com.company.project.entity.Order;

public interface OrderService {

    public abstract List<Order> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir);

    public abstract Order createOrder(Order order) throws Exception;

    public abstract List<Order> createOrders(List<Order> orderList) throws Exception;

    public abstract Order readOrders(Long id) throws Exception;

    public abstract List<Order> readAllOrders();

    public abstract Order updateOrders(Long id, Order order) throws Exception;

    public abstract String deleteOrders(Long id) throws Exception;

    public abstract Order patchOrders(Long id, Order order) throws Exception;

}
