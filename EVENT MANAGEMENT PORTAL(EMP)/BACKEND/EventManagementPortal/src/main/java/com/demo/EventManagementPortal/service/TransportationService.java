package com.demo.EventManagementPortal.service;
import java.util.List;
import com.demo.EventManagementPortal.beans.Transportation;

public interface TransportationService {

	//displayTransportation by id
	Transportation getTransportationById(int transportationid);
	
	//display all transportation
	List<Transportation> getAllTransportations();

	//update transportation
	int updateTransportation(Transportation transportation);

	//delete transportation
	boolean deleteTransportation(int transportationid);

	// add transportation
	void addTransportation(Transportation transportation);
}
