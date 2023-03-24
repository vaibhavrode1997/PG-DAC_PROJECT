package com.demo.EventManagementPortal.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.EventManagementPortal.beans.Services;
import com.demo.EventManagementPortal.service.ServiceService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/service")
public class ServiceController 
{

	@Autowired(required=false)
	ServiceService serviceService;

	//add service
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/services")
	public ResponseEntity<Services> addService(@RequestBody Services service){
		serviceService.addService(service);
		return new ResponseEntity(service,HttpStatus.CREATED);
	}

	//displayService by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/services/{serviceid}")
	public ResponseEntity<Services> getServiceById(@PathVariable int serviceid) {
		Services service=serviceService.getServiceById(serviceid);
		if(service!=null) {
			System.out.println(service);
			return new ResponseEntity(service,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//display all services 
	@GetMapping("/services")
	public ResponseEntity<List<Services>> getAllServices(){
		List<Services> serviceslist=serviceService.getAllServices();
		return ResponseEntity.ok(serviceslist);
	}

	//update service
	@PutMapping("/services")
	public ResponseEntity<Services> updateService(@RequestBody Services service) {

		List<Services> serviceslist=serviceService.getAllServices();
		for(Services service1:serviceslist)
		{
			if((service1.getOwner().equals(service.getOwner())) && (service1.getServicetype().equals(service.getServicetype())))
			{
				service1.setServicename(service.getServicename());
				service1.setServicetype(service.getServicetype());
				service1.setLocation(service.getLocation());
				service1.setOwner(service.getOwner());
				service1.setImage(service.getImage());
				serviceService.updateService(service1);
				return new ResponseEntity<Services>(service1,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<Services>(HttpStatus.BAD_REQUEST);
	}

	//delete service
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/services/{serviceid}")
	public ResponseEntity<String> deleteService(@PathVariable int serviceid) {
		boolean status=serviceService.deleteService(serviceid);
		if(status)
			return new ResponseEntity<String>("service deleted successfully "+ serviceid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
