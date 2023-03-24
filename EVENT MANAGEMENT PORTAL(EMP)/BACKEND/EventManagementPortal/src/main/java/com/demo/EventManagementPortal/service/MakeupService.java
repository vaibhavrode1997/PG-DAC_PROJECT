package com.demo.EventManagementPortal.service;

import java.util.List;

import com.demo.EventManagementPortal.beans.Makeup;

public interface MakeupService {

	//add makeup
	void addMakeup(Makeup makeup);

	//getMakeup by id
	Makeup getMakeupById(int makeupid);

	//get all makeups 
	List<Makeup> getAllMakeups();

	//update makeup
	int updateMakeup(Makeup makeup);

	//delete makeup
	boolean deleteMakeup(int makeupid);

}
