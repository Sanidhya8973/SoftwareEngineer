package com.company.project.service.interfaces;

import java.util.List;

import com.company.project.model.OrdersItem;

public interface OrdersItemService {

    public abstract List<OrdersItem> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir);

    public abstract OrdersItem createOrdersItem(OrdersItem ordersItem) throws Exception;

    public abstract List<OrdersItem> createOrdersItems(List<OrdersItem> ordersItemList) throws Exception;

    public abstract OrdersItem readOrdersItem(Long id) throws Exception;

    public abstract List<OrdersItem> readOrdersItems();

    public abstract OrdersItem updateOrdersItem(Long id, OrdersItem ordersItem) throws Exception;

    public abstract String deleteOrdersItem(Long id) throws Exception;

    public abstract OrdersItem patchOrdersItem(Long id, OrdersItem ordersItem) throws Exception;

}
