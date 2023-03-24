package com.demo.EventManagementPortal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.EventManagementPortal.beans.Musicsystem;
import com.demo.EventManagementPortal.dao.MusicsystemDao;

@Service
public class MusicsystemServiceImpl implements MusicsystemService
{
	@Autowired(required=false)
	MusicsystemDao musicsystemDao;

	//add Musicsystem
	@Override
	public void addMusicsystem(Musicsystem musicsystem) {
		musicsystemDao.saveAndFlush(musicsystem);
	}

	//getMusicsystem by id
	@Override
	public Musicsystem getMusicsystemById(int musicsystemid) {
		Optional<Musicsystem> op=musicsystemDao.findById(musicsystemid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all Musicsystems
	@Override
	public List<Musicsystem> getAllMusicsystem() {
		return musicsystemDao.findAll();
	}

	//update Musicsystem
	@Override
	public int updateMusicsystem(Musicsystem musicsystem) {
		Optional<Musicsystem> op=musicsystemDao.findById(musicsystem.getMusicsystemid());
		if(op.isPresent()) {
			Musicsystem musicsystem1=op.get();
			musicsystem1.setMusicsystemname(musicsystem.getMusicsystemname());
			musicsystem1.setRate(musicsystem.getRate());
			musicsystemDao.save(musicsystem1);
			return 1;
		}
		return 0;
	}

	//delete musicsystem
	@Override
	public boolean deleteMusicsystem(int musicsystemid) {
		Optional<Musicsystem> op=musicsystemDao.findById(musicsystemid);
		if(op.isPresent()) {
			musicsystemDao.deleteById(musicsystemid);
			return true;
		}
		return false;
	}
}
