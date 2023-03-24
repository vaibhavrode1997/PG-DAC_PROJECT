package com.demo.EventManagementPortal.service;

import java.util.List;

import com.demo.EventManagementPortal.beans.Caterer;

public interface CatererService {

	//add caterer
	void addCaterer(Caterer caterer);

	//getCaterer by id
	Caterer getCatererById(int catererid);

	//get all caterers 
	List<Caterer> getAllCaterers();

	//update caterer
	int updateCaterer(Caterer caterer);

	//delete caterer
	boolean deleteCaterer(int catererid);

}
