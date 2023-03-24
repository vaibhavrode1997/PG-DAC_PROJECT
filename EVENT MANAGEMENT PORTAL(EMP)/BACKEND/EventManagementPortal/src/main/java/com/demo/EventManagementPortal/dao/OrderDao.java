package com.demo.EventManagementPortal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.EventManagementPortal.beans.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{

}
