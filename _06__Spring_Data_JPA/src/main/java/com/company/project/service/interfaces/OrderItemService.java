package com.company.project.service.interfaces;

import java.util.List;

import com.company.project.entity.OrderItem;

public interface OrderItemService {

    public abstract List<OrderItem> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir);

    public abstract OrderItem createOrdersItem(OrderItem orderItem) throws Exception;

    public abstract List<OrderItem> createOrdersItems(List<OrderItem> orderItemList) throws Exception;

    public abstract OrderItem readOrdersItem(Long id) throws Exception;

    public abstract List<OrderItem> readOrdersItems();

    public abstract OrderItem updateOrdersItem(Long id, OrderItem orderItem) throws Exception;

    public abstract String deleteOrdersItem(Long id) throws Exception;

    public abstract OrderItem patchOrdersItem(Long id, OrderItem orderItem) throws Exception;

}
