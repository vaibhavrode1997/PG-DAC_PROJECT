package com.demo.EventManagementPortal.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.EventManagementPortal.beans.Bill;

public interface BillDao extends JpaRepository<Bill,Integer>
{

}
