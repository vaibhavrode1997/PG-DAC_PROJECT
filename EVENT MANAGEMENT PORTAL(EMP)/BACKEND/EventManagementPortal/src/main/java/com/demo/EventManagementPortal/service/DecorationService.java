package com.demo.EventManagementPortal.service;

import java.util.List;

import com.demo.EventManagementPortal.beans.Decoration;

public interface DecorationService {

	//add decoration
	void addDecoration(Decoration decoration);

	//getdecoration by id
	Decoration getDecorationById(int decorationid);

	//get all decorations
	List<Decoration> getAllDecorations();

	//update decoration
	int updateDecoration(Decoration decoration);

	//delete decoration
	boolean deleteDecoration(int decorationid);

}
