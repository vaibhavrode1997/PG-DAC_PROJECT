package com.demo.EventManagementPortal.service;

import java.util.List;
import com.demo.EventManagementPortal.beans.Order;

public interface OrderService {

	//add order
	 void addOrder(Order order);

	//get order by id
	Order getOrderById(int orderid);

	//get all order
	List<Order> getAllOrders();

	//update order
	int updateOrder(Order order);

	//delete order
	boolean deleteOrder(int orderid);

}
