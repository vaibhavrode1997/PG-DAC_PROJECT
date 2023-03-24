 package com.demo.EventManagementPortal.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.EventManagementPortal.beans.Hall;
import com.demo.EventManagementPortal.beans.Services;
import com.demo.EventManagementPortal.service.HallService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/hall")
public class HallController {
	@Autowired(required=false)
	HallService hallService;
	
	//add hall
	@PostMapping("/halls")
	public ResponseEntity<Hall> addHall(@RequestBody Hall hall){
		hallService.addHall(hall);
		return new ResponseEntity<Hall>(hall,HttpStatus.CREATED);
	}	

	//gethall by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/halls/{hallid}")
	public ResponseEntity<Hall> getHallById(@PathVariable int hallid) {
		System.out.println("in hall Controller.....");
		Hall hall=hallService.getHallById(hallid);
		if(hall!=null) {
			return new ResponseEntity(hall,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all halls 
	@GetMapping("/halls")
	public ResponseEntity<List<Hall>> getAllHalls(){
		List<Hall> halllist=hallService.getAllHalls();
		return ResponseEntity.ok(halllist);
	}

	//update hall
	@PutMapping("/halls")
	public ResponseEntity<Hall> updateHall(@RequestBody Hall hall) {
		List<Hall> halllist=hallService.getAllHalls();
		for(Hall hall1:halllist)
		{
			if(hall1.getName().equals(hall.getName()))
			{
				hall1.setName(hall.getName());
				hall1.setCapacity(hall.getCapacity());
				hall1.setRate(hall.getRate());
				hall1.setDescription(hall.getDescription());
				hallService.updateHall(hall1);
				return new ResponseEntity<Hall>(hall1,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<Hall>(HttpStatus.BAD_REQUEST);
	}

	//delete hall
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/halls/{hallid}")
	public ResponseEntity<String> deleteHall(@PathVariable int hallid) {
		boolean status=hallService.deleteHall(hallid);
		if(status)
			return new ResponseEntity<String>("hall deleted successfully "+ hallid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}		
}
