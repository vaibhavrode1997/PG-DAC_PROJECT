package com.demo.EventManagementPortal.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.EventManagementPortal.beans.DateTime;

public interface DateTimeDao extends JpaRepository<DateTime,Integer>
{

}
