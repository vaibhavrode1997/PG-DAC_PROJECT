package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.Light;
import com.demo.EventManagementPortal.dao.LightDao;

@Service
public class LightServiceImpl implements LightService{

	@Autowired(required=false)
	LightDao lightDao;
	
	//add light
	@Override
	public void addLight(Light light) {
		lightDao.saveAndFlush(light);
	}

	//getLight by id
	@Override
	public Light getLightById(int lightid) {
		Optional<Light> op=lightDao.findById(lightid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all lights 
	@Override
	public List<Light> getAllLights() {
		return lightDao.findAll();
	}

	//update light
	@Override
	public int updateLight(Light light) {
		Optional<Light> op=lightDao.findById(light.getLightid());
		if(op.isPresent()) {
			Light light1=op.get();
			light1.setName(light.getName());
			light1.setType(light.getType());
			light1.setRate(light.getRate());
			light1.setDecoration(light.getDecoration());
			lightDao.save(light1);
			return 1;
		}
		return 0;
	}

	//delete light
	@Override
	public boolean deleteLight(int lightid) {
		Optional<Light> op=lightDao.findById(lightid);
		if(op.isPresent()) {
			lightDao.deleteById(lightid);
			return true;
		}
		return false;
	}
}
