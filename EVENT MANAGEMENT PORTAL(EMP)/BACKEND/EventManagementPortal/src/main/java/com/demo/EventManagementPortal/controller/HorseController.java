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

import com.demo.EventManagementPortal.beans.FireCrackers;
import com.demo.EventManagementPortal.beans.Horse;
import com.demo.EventManagementPortal.service.HorseService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/horse")
public class HorseController {
	@Autowired(required=false)
	HorseService horseService;

	//add horse
	@PostMapping("/horses")
	public ResponseEntity<Horse> addHorse(@RequestBody Horse horse){
		horseService.addHorse(horse);
		return new ResponseEntity<Horse>(horse,HttpStatus.CREATED);
	}	

	//getHorse by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/horses/{horseid}")
	public ResponseEntity<Horse> getHorseById(@PathVariable int horseid) {
		Horse service=horseService.getHorseById(horseid);
		if(service!=null) {
			return new ResponseEntity(service,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all horses 
	@GetMapping("/horses")
	public ResponseEntity<List<Horse>> getAllHorses(){
		List<Horse> horselist=horseService.getAllHorses();
		return ResponseEntity.ok(horselist);
	}

	//update horse
	@PutMapping("/horses")
	public ResponseEntity<Horse> updateHorse(@RequestBody Horse horse) {
		List<Horse> horselist=horseService.getAllHorses();
		for(Horse horse1:horselist)
		{
			if(horse1.getName().equals(horse.getName()))
			{
				horse1.setColor(horse.getColor());
				horse1.setName(horse.getName());
				horse1.setRate(horse.getRate());
				horse1.setDescription(horse.getDescription());
				horseService.updateHorse(horse1);
				return new ResponseEntity<Horse>(horse1,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<Horse>(HttpStatus.BAD_REQUEST);
	}

	//delete horse
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/horses/{horseid}")
	public ResponseEntity<String> deleteEvent(@PathVariable int horseid) {
		boolean status=horseService.deleteHorse(horseid);
		if(status)
			return new ResponseEntity<String>("horse deleted successfully "+ horseid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
