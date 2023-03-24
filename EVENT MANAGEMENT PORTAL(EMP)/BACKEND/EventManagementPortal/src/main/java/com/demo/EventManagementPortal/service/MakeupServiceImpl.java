package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.Makeup;
import com.demo.EventManagementPortal.dao.MakeupDao;

@Service
public class MakeupServiceImpl implements MakeupService{

	@Autowired(required=false)
	MakeupDao makeupDao;
	
	@Override
	public void addMakeup(Makeup makeup) {
		makeupDao.saveAndFlush(makeup);
	}

	@Override
	public Makeup getMakeupById(int makeupid) {
		Optional<Makeup> op=makeupDao.findById(makeupid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	@Override
	public List<Makeup> getAllMakeups() {
		return makeupDao.findAll();
	}

	@Override
	public int updateMakeup(Makeup makeup) {
		Optional<Makeup> op=makeupDao.findById(makeup.getMakeupid());
		if(op.isPresent()) {
			Makeup makeup1=op.get();
			makeup1.setName(makeup.getName());
			makeup1.setType(makeup.getType());
			makeup1.setRate(makeup.getRate());
			makeup1.setDescription(makeup.getDescription());
			makeupDao.save(makeup1);
			return 1;
		}
		return 0;
	}

	@Override
	public boolean deleteMakeup(int makeupid) {
		Optional<Makeup> op=makeupDao.findById(makeupid);
		if(op.isPresent()) {
			makeupDao.deleteById(makeupid);
			return true;
		}
		return false;
	}
}
