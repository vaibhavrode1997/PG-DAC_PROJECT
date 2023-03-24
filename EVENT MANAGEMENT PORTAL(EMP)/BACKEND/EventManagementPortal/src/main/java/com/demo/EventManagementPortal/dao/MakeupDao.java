package com.demo.EventManagementPortal.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.EventManagementPortal.beans.Makeup;

public interface MakeupDao extends JpaRepository<Makeup,Integer>
{

}
