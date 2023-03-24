package com.demo.EventManagementPortal.service;

import java.util.List;

import com.demo.EventManagementPortal.beans.Flower;

public interface FlowerService {

	//add flower
	void addFlower(Flower flower);

	//getFlower by id
	Flower getFlowerById(int flowerid);

	//get all flowers 
	List<Flower> getAllFlowers();

	//update flower
	int updateFlower(Flower flower);

	//delete flower
	boolean deleteFlower(int flowerid);
}
