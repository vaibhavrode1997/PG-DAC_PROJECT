package com.demo.EventManagementPortal.service;

import java.util.List;

import com.demo.EventManagementPortal.beans.Photography;

public interface PhotographyService {

	//add photography
	void addPhotography(Photography photography);

	//getPhotography by id
	Photography getPhotographyById(int photographyid);

	//get all photography 
	List<Photography> getAllPhotography();

	//update photography
	int updatePhotography(Photography photography);

	//delete photography
	boolean deletePhotography(int photographyid);

}
