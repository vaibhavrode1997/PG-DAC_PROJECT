package com.demo.EventManagementPortal.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.EventManagementPortal.beans.Payment;

public interface PaymentDao extends JpaRepository<Payment,Integer>
{

}
