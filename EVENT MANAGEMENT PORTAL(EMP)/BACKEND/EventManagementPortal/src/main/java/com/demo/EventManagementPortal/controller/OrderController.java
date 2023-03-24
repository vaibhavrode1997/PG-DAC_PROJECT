package com.demo.EventManagementPortal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.EventManagementPortal.beans.Order;
import com.demo.EventManagementPortal.service.OrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/order")
public class OrderController {

	@Autowired(required=false)
	OrderService orderService;

	//add order
	@PostMapping("/orders")
	public ResponseEntity<Order> addOrder(@RequestBody Order order){
		orderService.addOrder(order);
		return new ResponseEntity<Order>(order,HttpStatus.CREATED);
	}	

	//get order by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/orders/{orderid}")
	public ResponseEntity<Order> getOrderById(@PathVariable int orderid) {
		Order order=orderService.getOrderById(orderid);
		if(order!=null) {
			return new ResponseEntity(order,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all order
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders(){
		List<Order> orderlist=orderService.getAllOrders();
		return ResponseEntity.ok(orderlist);
	}

	//update order
	@PutMapping("/orders")
	public ResponseEntity<String> updateOrder(@RequestBody Order order) {
		int n=orderService.updateOrder(order);
		if(n>0)
			return new ResponseEntity<String>("order updated successfully "+order,HttpStatus.CREATED);
		else
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	//delete order
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/orders/{orderid}")
	public ResponseEntity<String> deleteOrder(@PathVariable int orderid) {
		boolean status=orderService.deleteOrder(orderid);
		if(status)
			return new ResponseEntity<String>("order deleted successfully "+ orderid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}		
}
