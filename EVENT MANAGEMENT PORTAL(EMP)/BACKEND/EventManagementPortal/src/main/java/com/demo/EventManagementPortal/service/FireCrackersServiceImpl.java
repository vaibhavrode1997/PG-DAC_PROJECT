package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.EventManagementPortal.beans.FireCrackers;
import com.demo.EventManagementPortal.dao.FireCrackersDao;

@Service
public class FireCrackersServiceImpl implements FireCrackersService{
	@Autowired(required=false)
	FireCrackersDao fireCrackersDao;
	
	//add fireCrackers
	@Override
	public void addFireCrackers(FireCrackers fireCrackers) {
		fireCrackersDao.saveAndFlush(fireCrackers);	
	}

	//getFireCrackers by id
	@Override
	public FireCrackers getFireCrackersById(int fireCrackersid) {
		Optional<FireCrackers> op=fireCrackersDao.findById(fireCrackersid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all fireCrackers
	@Override
	public List<FireCrackers> getAllFireCrackers() {
		return fireCrackersDao.findAll();
	}

	//update fireCrackers
	@Override
	public int updateFireCrackers(FireCrackers fireCrackers) {
		Optional<FireCrackers> op=fireCrackersDao.findById(fireCrackers.getFirecrackersid());
		if(op.isPresent()) {
			FireCrackers fireCrackers1=op.get();
			fireCrackers1.setName(fireCrackers.getName());
			fireCrackers1.setType(fireCrackers.getType());
			fireCrackers1.setRate(fireCrackers.getRate());
			fireCrackers1.setDescription(fireCrackers.getDescription());
			fireCrackersDao.save(fireCrackers1);
			return 1;
		}
		return 0;
	}

	//delete fireCrackers
	@Override
	public boolean deleteFireCrackers(int fireCrackersid) {
		Optional<FireCrackers> op=fireCrackersDao.findById(fireCrackersid);
		if(op.isPresent()) {
			fireCrackersDao.deleteById(fireCrackersid);
			return true;
		}
		return false;
	}
}
