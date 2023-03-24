package com.demo.EventManagementPortal.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.EventManagementPortal.beans.Light;

public interface LightDao extends JpaRepository<Light,Integer>
{

}
