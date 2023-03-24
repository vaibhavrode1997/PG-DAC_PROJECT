package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.EventManagementPortal.beans.Services;
import com.demo.EventManagementPortal.dao.ServiceDao;
import com.mysql.cj.x.protobuf.MysqlxResultset.FetchSuspendedOrBuilder;

@Service
public class ServiceServiceImpl implements ServiceService
{
	@Autowired(required=false)
	ServiceDao serviceDao;

	//add service
	@Override
	public void addService(Services service) {
		serviceDao.saveAndFlush(service);
	}

	//displayService by id
	@Override
	public Services getServiceById(int serviceid) {
		Optional<Services> op=serviceDao.findById(serviceid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//display all services
	@Override
	public List<Services> getAllServices(){
		System.out.println("in get all service..");
		return serviceDao.findAll();
	}

	//update service 
	@Override
	public int updateService(Services service) {
		Optional<Services> op=serviceDao.findById(service.getServiceid());
		if(op.isPresent()) {
			Services service1=op.get();
			service1.setServicename(service.getServicename());
			service1.setServicetype(service.getServicetype());
			service1.setLocation(service.getLocation());
			service1.setOwner(service.getOwner());
			service1.setImage(service.getImage());
			serviceDao.saveAndFlush(service1);
			return 1;
		}
		return 0;
	}

	//delete service
	@Override
	public boolean deleteService(int serviceid) {
		Optional<Services> op=serviceDao.findById(serviceid);
		if(op.isPresent()) {
			serviceDao.deleteById(serviceid);
			return true;
		}
		return false;

	}

}
