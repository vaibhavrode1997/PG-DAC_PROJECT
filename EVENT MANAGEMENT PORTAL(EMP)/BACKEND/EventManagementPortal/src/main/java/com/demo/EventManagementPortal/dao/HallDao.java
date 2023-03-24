package com.demo.EventManagementPortal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.EventManagementPortal.beans.Hall;

public interface HallDao extends JpaRepository<Hall, Integer>{

}
