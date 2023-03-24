package com.demo.EventManagementPortal.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.Order;
import com.demo.EventManagementPortal.dao.OrderDao;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;

	//add order
	@Override
	public void addOrder(Order order) {
		orderDao.saveAndFlush(order);	
	}

	//get order by id
	@Override
	public Order getOrderById(int orderid) {
		Optional<Order> op=orderDao.findById(orderid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all order
	@Override
	public List<Order> getAllOrders() {
		return orderDao.findAll();
	}

	//update order
	@Override
	public int updateOrder(Order order) {
		Optional<Order> op=orderDao.findById(order.getOrderid());
		if(op.isPresent()) {
			Order order1=op.get();
			order1.setEmail(order.getEmail());
			order1.setStatus(order.getStatus());
			orderDao.save(order1);
			return 1;
		}
		return 0;
	}

	//delete order
	@Override
	public boolean deleteOrder(int orderid) {
		Optional<Order> op=orderDao.findById(orderid);
		if(op.isPresent()) {
			orderDao.deleteById(orderid);
			return true;
		}
		return false;
	}

	
}
