package com.demo.EventManagementPortal.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.Caterer;
import com.demo.EventManagementPortal.dao.CatererDao;

@Service
public class CatererServiceImpl implements CatererService{
	
	@Autowired
	CatererDao catererDao;

	//add caterer
	@Override
	public void addCaterer(Caterer caterer) {
		catererDao.saveAndFlush(caterer);	
		
	}

	//getCaterer by id
	@Override
	public Caterer getCatererById(int catererid) {
		Optional<Caterer> op=catererDao.findById(catererid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all caterers 
	@Override
	public List<Caterer> getAllCaterers() {
		return catererDao.findAll();
	}

	//update caterer
	@Override
	public int updateCaterer(Caterer caterer) {
		Optional<Caterer> op=catererDao.findById(caterer.getCatererid());
		if(op.isPresent()) {
			Caterer caterer1=op.get();
			caterer1.setCapacity(caterer.getCapacity());
			caterer1.setDescription(caterer.getDescription());
			caterer1.setItem(caterer.getItem());
			caterer1.setName(caterer.getName());
			caterer1.setRate(caterer.getRate());
			catererDao.save(caterer1);
			return 1;
		}
		return 0;
	}

	//delete caterer
	@Override
	public boolean deleteCaterer(int catererid) {
		Optional<Caterer> op=catererDao.findById(catererid);
		if(op.isPresent()) {
			catererDao.deleteById(catererid);
			return true;
		}
		return false;
	}
}
