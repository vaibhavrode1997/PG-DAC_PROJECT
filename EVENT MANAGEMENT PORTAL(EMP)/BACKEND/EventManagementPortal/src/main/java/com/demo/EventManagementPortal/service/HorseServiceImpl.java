package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.Horse;
import com.demo.EventManagementPortal.dao.HorseDao;

@Service
public class HorseServiceImpl implements HorseService
{
	@Autowired(required=false)
	HorseDao horseDao;

	//add horse
	@Override
	public void addHorse(Horse horse) {
		horseDao.saveAndFlush(horse);
	}

	//getHorse by id
	@Override
	public Horse getHorseById(int horseid) {
		Optional<Horse> op=horseDao.findById(horseid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all horse
	@Override
	public List<Horse> getAllHorses() {
		return horseDao.findAll();
	}

	//update horse
	@Override
	public int updateHorse(Horse horse) {
		Optional<Horse> op=horseDao.findById(horse.getHorseid());
		if(op.isPresent()) {
			Horse horse1=op.get();
			horse1.setColor(horse.getColor());
			horse1.setName(horse.getName());
			horse1.setRate(horse.getRate());
			horse1.setDescription(horse.getDescription());
			horseDao.save(horse1);
			return 1;
		}
		return 0;
	}

	//delete horse
	@Override
	public boolean deleteHorse(int horseid) 
	{
		Optional<Horse> op=horseDao.findById(horseid);
		if(op.isPresent()) {
			horseDao.deleteById(horseid);
			return true;
		}
		return false;
	}
}
