package com.demo.EventManagementPortal.service;
import java.util.List;
import com.demo.EventManagementPortal.beans.Musicsystem;

public interface MusicsystemService {

	//add Musicsystem
	void addMusicsystem(Musicsystem musicsystem);

	//getMusicsystem by id
	Musicsystem getMusicsystemById(int musicsystemid);

	//get all Musicsystems 
	List<Musicsystem> getAllMusicsystem();

	//update Musicsystem
	int updateMusicsystem(Musicsystem musicsystem);

	//delete Musicsystem
	boolean deleteMusicsystem(int musicsystemid);
}
