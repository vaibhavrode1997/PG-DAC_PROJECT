package com.demo.EventManagementPortal.service;
import java.util.List;

import com.demo.EventManagementPortal.beans.Services;

public interface ServiceService 
{


	//add service
	public void addService(Services service);

	//displayService by id
	public Services getServiceById(int serviceid);

	//display all services
	public List<Services> getAllServices();

	//update service
	public int updateService(Services service);

	//delete service
	public boolean deleteService(int serviceid);




}
