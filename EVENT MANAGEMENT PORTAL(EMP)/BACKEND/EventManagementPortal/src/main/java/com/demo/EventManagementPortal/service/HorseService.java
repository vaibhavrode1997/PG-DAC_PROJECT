package com.demo.EventManagementPortal.service;

import java.util.List;

import com.demo.EventManagementPortal.beans.Horse;

public interface HorseService {

	//add horse
	void addHorse(Horse horse);

	//getHorse by id
	Horse getHorseById(int horseid);

	//get all horses 
	List<Horse> getAllHorses();

	//update horse
	int updateHorse(Horse horse);

	//delete horse
	boolean deleteHorse(int horseid);

}
