package com.demo.EventManagementPortal.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.EventManagementPortal.beans.Services;

public interface ServiceDao extends JpaRepository<Services, Integer> 
{

	
}
