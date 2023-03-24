package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.Hall;
import com.demo.EventManagementPortal.dao.HallDao;

@Service
public class HallServiceImpl implements HallService{

	@Autowired(required=false)
	HallDao hallDao;

	//add hall
	@Override
	public void addHall(Hall hall) {
		System.out.println("hall added");
		hallDao.saveAndFlush(hall);	
	}

	//gethall by id
	@Override
	public Hall getHallById(int hallid) {
		Optional<Hall> op=hallDao.findById(hallid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all halls 
	@Override
	public List<Hall> getAllHalls() {
		return hallDao.findAll();
	}

	//update hall
	@Override
	public int updateHall(Hall hall) {
		Optional<Hall> op=hallDao.findById(hall.getHallid());
		if(op.isPresent()) {
			Hall hall1=op.get();
			hall1.setCapacity(hall.getCapacity());
			hall1.setDescription(hall.getDescription());
			hall1.setName(hall.getName());
			hall1.setRate(hall.getRate());
			hallDao.saveAndFlush(hall1);
			return 1;
		}
		return 0;
	}

	//delete hall
	@Override
	public boolean deleteHall(int hallid) {
		Optional<Hall> op=hallDao.findById(hallid);
		if(op.isPresent()) {
			hallDao.deleteById(hallid);
			return true;
		}
		return false;
	}	
}
