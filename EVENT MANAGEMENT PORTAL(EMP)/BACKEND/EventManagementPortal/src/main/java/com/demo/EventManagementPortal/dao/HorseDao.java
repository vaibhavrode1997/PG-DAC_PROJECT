package com.demo.EventManagementPortal.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.EventManagementPortal.beans.Horse;

public interface HorseDao extends JpaRepository<Horse,Integer>
{

}
