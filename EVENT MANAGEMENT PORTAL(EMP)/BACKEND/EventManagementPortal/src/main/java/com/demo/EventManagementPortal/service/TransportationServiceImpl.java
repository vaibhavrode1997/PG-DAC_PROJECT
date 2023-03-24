package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.EventManagementPortal.beans.Transportation;
import com.demo.EventManagementPortal.dao.TransportationDao;

@Service
public class TransportationServiceImpl implements TransportationService{
	@Autowired(required=false)
	TransportationDao transportationDao;
	
	//add transportation
	@Override
	public void addTransportation(Transportation transportation) {
		transportationDao.saveAndFlush(transportation);	
	}
	
	//getTransportation by id
	@Override
	public Transportation getTransportationById(int transportationid) {
		Optional<Transportation> op=transportationDao.findById(transportationid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all transportation
	@Override
	public List<Transportation> getAllTransportations() {
		return transportationDao.findAll();
	}

	//update transportation
	@Override
	public int updateTransportation(Transportation transportation) {
		Optional<Transportation> op=transportationDao.findById(transportation.getTransportationid());
		if(op.isPresent()) {
			Transportation transportation1=op.get();
			transportation1.setName(transportation.getName());
			transportation1.setType(transportation.getType());
			transportation1.setRate(transportation.getRate());
			transportation1.setDescription(transportation.getDescription());
			transportationDao.save(transportation1);
			return 1;
		}
		return 0;
	}

	//delete transportation
	@Override
	public boolean deleteTransportation(int transportationid) {
		Optional<Transportation> op=transportationDao.findById(transportationid);
		if(op.isPresent()) {
			transportationDao.deleteById(transportationid);
			return true;
		}
		return false;
	}
}
