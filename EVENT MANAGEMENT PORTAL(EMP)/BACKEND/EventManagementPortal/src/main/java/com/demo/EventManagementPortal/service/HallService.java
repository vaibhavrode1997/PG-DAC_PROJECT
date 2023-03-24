package com.demo.EventManagementPortal.service;

import java.util.List;

import com.demo.EventManagementPortal.beans.Hall;

public interface HallService {

	//add hall
	void addHall(Hall hall);

	//gethall by id
	Hall getHallById(int hallid);

	//get all halls 
	List<Hall> getAllHalls();

	//update hall
	int updateHall(Hall hall);

	//delete hall
	boolean deleteHall(int hallid);
}
