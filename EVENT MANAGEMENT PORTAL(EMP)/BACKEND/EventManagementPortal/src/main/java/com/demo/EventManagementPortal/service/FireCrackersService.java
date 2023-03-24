package com.demo.EventManagementPortal.service;
import java.util.List;
import com.demo.EventManagementPortal.beans.FireCrackers;

public interface FireCrackersService {

	//add fireCracker
	void addFireCrackers(FireCrackers fireCrackers);

	//getFireCracker by id
	FireCrackers getFireCrackersById(int fireCrackersid);

	//get all fireCrackers 
	List<FireCrackers> getAllFireCrackers();

	//update fireCracker
	int updateFireCrackers(FireCrackers fireCrackers);

	//delete fireCracker
	boolean deleteFireCrackers(int fireCrackersid);
}
