package com.demo.EventManagementPortal.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.EventManagementPortal.beans.Photography;

public interface PhotographyDao extends JpaRepository<Photography,Integer>
{

}
