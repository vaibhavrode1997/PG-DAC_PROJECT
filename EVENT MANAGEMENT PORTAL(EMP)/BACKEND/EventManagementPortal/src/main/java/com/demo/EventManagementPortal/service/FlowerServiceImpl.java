package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.Flower;
import com.demo.EventManagementPortal.dao.FlowerDao;

@Service
public class FlowerServiceImpl implements FlowerService{

	@Autowired(required=false)
	FlowerDao flowerDao;
	
	//add flower
	@Override
	public void addFlower(Flower flower) {
		flowerDao.saveAndFlush(flower);	
	}

	//getFlower by id
	@Override
	public Flower getFlowerById(int flowerid) {
		Optional<Flower> op=flowerDao.findById(flowerid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all flowers 
	@Override
	public List<Flower> getAllFlowers() {
		return flowerDao.findAll();
	}

	//update flower
	@Override
	public int updateFlower(Flower flower) {
		Optional<Flower> op=flowerDao.findById(flower.getFlowerid());
		if(op.isPresent()) {
			Flower flower1=op.get();
			flower1.setName(flower.getName());
			flower1.setType(flower.getType());
			flower1.setRate(flower.getRate());
			flower1.setDecoration(flower.getDecoration());
			flowerDao.save(flower1);
			return 1;
		}
		return 0;
	}

	//delete flower
	@Override
	public boolean deleteFlower(int flowerid) {
		Optional<Flower> op=flowerDao.findById(flowerid);
		if(op.isPresent()) {
			flowerDao.deleteById(flowerid);
			return true;
		}
		return false;
	}
}
