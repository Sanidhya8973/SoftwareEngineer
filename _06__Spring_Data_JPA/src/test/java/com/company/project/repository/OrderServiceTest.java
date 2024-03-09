package com.company.project.repository;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.company.project.entity.Address;
import com.company.project.entity.OrderItem;
import com.company.project.entity.Order;
import com.company.project.service.OrderServiceImp;
import com.company.project.service.ProductServiceImp;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderServiceImp orderServiceImp;

    @Autowired
    private ProductServiceImp productServiceImp;

    @Test
    @DisplayName("test: persist orders")
    protected void test() throws Exception {

        Order o1 = new Order();
        o1.setTrackingNumber("order-1-1");
        o1.setStatus("order placed");

        Address a1 = new Address();
        a1.setStreet("street-1");
        a1.setPincode("pincode-1");
        a1.setCity("city-1");
        a1.setState("state-1");
        a1.setCountry("country-1");
        a1.setOrder(o1);

        OrderItem oi1 = new OrderItem();
        oi1.setProduct(productServiceImp.readProduct(1L));
        oi1.setOrder(o1);
        oi1.setQuantity(2);
        oi1.setTotalOrdersItemAmount(oi1.getTotalAmount());

        OrderItem oi2 = new OrderItem();
        oi2.setProduct(productServiceImp.readProduct(2L));
        oi2.setOrder(o1);
        oi2.setQuantity(3);
        oi2.setTotalOrdersItemAmount(oi2.getTotalAmount());

        o1.setAddress(a1);
        o1.setOrderItemList(List.of(oi1, oi2));
        o1.setTotalQuantity(o1.getOrderItemList().size());
        o1.setTotalPrice(o1.getTotalAmount());

        orderServiceImp.createOrders(o1);

    }

    //	@Test
//	@DisplayName("test: merge order")
    protected void update() throws Exception {
        Long id = 1L;
        Order order = orderServiceImp.readOrders(id);
        order.setTrackingNumber("order-69-69");
        orderServiceImp.createOrders(order);
    }

    //	@Test
    // protected void deleteAll() { ordersServiceImp.deleteAll(); }

    //	@Test
    protected void doPaginationAndSorting() {
        orderServiceImp.doPaginationAndSorting(0, 3, new String[]{"totalPrice"}, "desc").forEach(System.out::println);
    }

}
