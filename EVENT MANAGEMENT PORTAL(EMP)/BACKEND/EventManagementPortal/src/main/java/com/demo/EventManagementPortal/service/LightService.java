package com.demo.EventManagementPortal.service;

import java.util.List;

import com.demo.EventManagementPortal.beans.Light;

public interface LightService {

	//add light
	void addLight(Light light);

	//getLight by id
	Light getLightById(int lightid);

	//get all lights 
	List<Light> getAllLights();

	//update light
	int updateLight(Light light);

	//delete light
	boolean deleteLight(int lightid);

}
