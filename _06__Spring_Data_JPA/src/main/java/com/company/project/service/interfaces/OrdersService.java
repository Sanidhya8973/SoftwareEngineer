package com.company.project.service.interfaces;

import java.util.List;

import com.company.project.model.Orders;

public interface OrdersService {

    public abstract List<Orders> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir);

    public abstract Orders createOrders(Orders orders) throws Exception;

    public abstract List<Orders> createAllOrders(List<Orders> ordersList) throws Exception;

    public abstract Orders readOrders(Long id) throws Exception;

    public abstract List<Orders> readAllOrders();

    public abstract Orders updateOrders(Long id, Orders orders) throws Exception;

    public abstract String deleteOrders(Long id) throws Exception;

    public abstract Orders patchOrders(Long id, Orders orders) throws Exception;

}
