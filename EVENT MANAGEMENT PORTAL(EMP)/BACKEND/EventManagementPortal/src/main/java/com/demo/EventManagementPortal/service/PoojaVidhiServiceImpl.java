package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.EventManagementPortal.beans.PoojaVidhi;
import com.demo.EventManagementPortal.dao.PoojaVidhiDao;

@Service
public class PoojaVidhiServiceImpl implements PoojaVidhiService{
	@Autowired(required=false)
	PoojaVidhiDao poojaVidhiDao;

	//add poojaVidhi
	@Override
	public void addPoojaVidhi(PoojaVidhi poojaVidhi) {
		poojaVidhiDao.saveAndFlush(poojaVidhi);	
	}

	//getPoojaVidhi by id
	@Override
	public PoojaVidhi getPoojaVidhiById(int poojaVidhiid) {
		Optional<PoojaVidhi> op=poojaVidhiDao.findById(poojaVidhiid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all poojaVidhis 
	@Override
	public List<PoojaVidhi> getAllPoojaVidhi() {
		return poojaVidhiDao.findAll();
	}

	//update PoojaVidhi
	@Override
	public int updatePoojaVidhi(PoojaVidhi poojaVidhi) {
		Optional<PoojaVidhi> op=poojaVidhiDao.findById(poojaVidhi.getPoojavidhiid());
		if(op.isPresent()) {
			PoojaVidhi poojaVidhi1=op.get();
			poojaVidhi1.setName(poojaVidhi.getName());
			poojaVidhi1.setType(poojaVidhi.getType());
			poojaVidhi1.setRate(poojaVidhi.getRate());
			poojaVidhi1.setDescription(poojaVidhi.getDescription());
			poojaVidhiDao.save(poojaVidhi1);
			return 1;
		}
		return 0;
	}

	//delete poojaVidhi
	@Override
	public boolean deletePoojaVidhi(int poojaVidhiid) {
		Optional<PoojaVidhi> op=poojaVidhiDao.findById(poojaVidhiid);
		if(op.isPresent()) {
			poojaVidhiDao.deleteById(poojaVidhiid);
			return true;
		}
		return false;
	}

}
