package com.company.project.repository;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.company.project.model.Address;
import com.company.project.model.OrdersItem;
import com.company.project.model.Orders;
import com.company.project.service.OrdersService;
import com.company.project.service.ProductService;

@SpringBootTest
public class OrdersServiceTest {

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private ProductService productService;

	@Test
	@DisplayName("test: persist orders")
	protected void test() {

		Orders o1 = new Orders();
		o1.setTrackingNumber("order-1-1");
		o1.setStatus("order placed");

		Address a1 = new Address();
		a1.setStreet("street-1");
		a1.setPincode("pincode-1");
		a1.setCity("city-1");
		a1.setState("state-1");
		a1.setCountry("country-1");
		a1.setOrders(o1);

		OrdersItem oi1 = new OrdersItem();
		oi1.setProduct(productService.findById(1L));
		oi1.setOrders(o1);
		oi1.setQuantity(2);
		oi1.setTotalOrdersItemAmount(oi1.getTotalAmount());

		OrdersItem oi2 = new OrdersItem();
		oi2.setProduct(productService.findById(2L));
		oi2.setOrders(o1);
		oi2.setQuantity(3);
		oi2.setTotalOrdersItemAmount(oi2.getTotalAmount());

		o1.setAddress(a1);
		o1.setOrdersItemList(List.of(oi1, oi2));
		o1.setTotalQuantity(o1.getOrdersItemList().size());
		o1.setTotalPrice(o1.getTotalAmount());

		ordersService.save(o1);

	}

//	@Test
//	@DisplayName("test: merge order")
	protected void update() {
		Long id = 1L;
		Orders order = ordersService.findById(id);
		order.setTrackingNumber("order-69-69");
		ordersService.save(order);
	}

//	@Test
	protected void deleteAll() {
		ordersService.deleteAll();
	}

//	@Test
	protected void doPaginationAndSorting() {
		ordersService.doPaginationAndSorting(0, 3, new String[] { "totalPrice" }, "desc").forEach(System.out::println);
	}

}
