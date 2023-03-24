package com.demo.EventManagementPortal.service;
import java.util.List;
import com.demo.EventManagementPortal.beans.PoojaVidhi;

public interface PoojaVidhiService {

	//add poojaVidhi
	void addPoojaVidhi(PoojaVidhi poojaVidhi);

	//getPoojaVidhi by id
	PoojaVidhi getPoojaVidhiById(int poojaVidhiid);

	//get all poojaVidhis 
	List<PoojaVidhi> getAllPoojaVidhi();

	//update PoojaVidhi
	int updatePoojaVidhi(PoojaVidhi poojaVidhi);

	//delete poojaVidhi
	boolean deletePoojaVidhi(int poojaVidhiid);
}
