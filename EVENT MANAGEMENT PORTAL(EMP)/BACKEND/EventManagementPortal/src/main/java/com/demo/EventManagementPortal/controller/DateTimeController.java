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

import com.demo.EventManagementPortal.beans.DateTime;
import com.demo.EventManagementPortal.service.DateTimeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/dateTime")
public class DateTimeController {

	@Autowired(required=false)
	DateTimeService dateTimeService;

	//add dateTime
	@PostMapping("/dateTimes")
	public ResponseEntity<DateTime> addDateTime(@RequestBody DateTime dateTime){
		dateTimeService.addDateTime(dateTime);
		return new ResponseEntity<DateTime>(dateTime,HttpStatus.CREATED);
	}	

	//getdateTime by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/dateTimes/{dateTimeid}")
	public ResponseEntity<DateTime> getDateTimeById(@PathVariable int dateTimeid) {
		DateTime service=dateTimeService.getDateTimeById(dateTimeid);
		if(service!=null) {
			return new ResponseEntity(service,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all dateTimes 
	@GetMapping("/dateTimes")
	public ResponseEntity<List<DateTime>> getAllDateTimes(){
		List<DateTime> dateTimelist=dateTimeService.getAllDateTimes();
		return ResponseEntity.ok(dateTimelist);
	}

	//update dateTime
	@PutMapping("/dateTimes")
	public ResponseEntity<String> updateDateTime(@RequestBody DateTime dateTime) {
		int n=dateTimeService.updateDateTime(dateTime);
		if(n>0)
			return new ResponseEntity<String>("dateTime updated successfully "+dateTime,HttpStatus.CREATED);
		else
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	//delete dateTime
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/dateTimes/{dateTimeid}")
	public ResponseEntity<String> deletedateTime(@PathVariable int dateTimeid) {
		boolean status=dateTimeService.deletedateTime(dateTimeid);
		if(status)
			return new ResponseEntity<String>("dateTime deleted successfully "+ dateTimeid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
