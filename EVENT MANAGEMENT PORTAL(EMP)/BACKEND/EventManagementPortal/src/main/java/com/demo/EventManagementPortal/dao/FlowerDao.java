package com.demo.EventManagementPortal.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.EventManagementPortal.beans.Flower;

public interface FlowerDao extends JpaRepository<Flower,Integer>
{

}
