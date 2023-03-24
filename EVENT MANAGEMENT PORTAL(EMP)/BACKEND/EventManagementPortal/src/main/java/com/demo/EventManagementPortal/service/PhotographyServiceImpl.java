package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.Photography;
import com.demo.EventManagementPortal.dao.PhotographyDao;

@Service
public class PhotographyServiceImpl implements PhotographyService{

	@Autowired(required=false)
	PhotographyDao photographyDao;
	
	//add photography
	@Override
	public void addPhotography(Photography photography) {
		photographyDao.saveAndFlush(photography);
	}

	//getPhotography by id
	@Override
	public Photography getPhotographyById(int photographyid) {
		Optional<Photography> op=photographyDao.findById(photographyid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all photography 
	@Override
	public List<Photography> getAllPhotography() {
		return photographyDao.findAll();
	}

	//update photography
	@Override
	public int updatePhotography(Photography photography) {
		Optional<Photography> op=photographyDao.findById(photography.getPhotographyid());
		if(op.isPresent()) {
			Photography photography1=op.get();
			photography1.setName(photography.getName());
			photography1.setType(photography.getType());
			photography1.setRate(photography.getRate());
			photography1.setDescription(photography.getDescription());
			photographyDao.save(photography1);
			return 1;
		}
		return 0;
	}

	//delete photography
	@Override
	public boolean deletePhotography(int photographyid) {
		Optional<Photography> op=photographyDao.findById(photographyid);
		if(op.isPresent()) {
			photographyDao.deleteById(photographyid);
			return true;
		}
		return false;
	}
}
