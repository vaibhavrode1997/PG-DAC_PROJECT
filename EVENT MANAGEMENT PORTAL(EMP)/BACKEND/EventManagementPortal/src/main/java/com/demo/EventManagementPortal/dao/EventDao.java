package com.demo.EventManagementPortal.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.EventManagementPortal.beans.Event;

public interface EventDao extends JpaRepository<Event,Integer>
{
  
}
