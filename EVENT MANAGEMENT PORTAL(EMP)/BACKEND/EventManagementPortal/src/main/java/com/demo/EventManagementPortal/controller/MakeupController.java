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

import com.demo.EventManagementPortal.beans.Flower;
import com.demo.EventManagementPortal.beans.Makeup;
import com.demo.EventManagementPortal.service.MakeupService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/makeup")
public class MakeupController {
	@Autowired(required=false)
	MakeupService makeupService;
	
	//add makeup
		@PostMapping("/makeups")
		public ResponseEntity<Makeup> addMakeup(@RequestBody Makeup makeup){
			makeupService.addMakeup(makeup);
			return new ResponseEntity<Makeup>(makeup,HttpStatus.CREATED);
		}	

		//getMakeup by id
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@GetMapping("/makeups/{makeupid}")
		public ResponseEntity<Makeup> getMakeupById(@PathVariable int makeupid) {
			Makeup makeup=makeupService.getMakeupById(makeupid);
			if(makeup!=null) {
				return new ResponseEntity(makeup,HttpStatus.OK);
			}
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		//get all makeups 
		@GetMapping("/makeups")
		public ResponseEntity<List<Makeup>> getAllMakeups(){
			List<Makeup> makeuplist=makeupService.getAllMakeups();
			return ResponseEntity.ok(makeuplist);
		}

		//update makeup
		@PutMapping("/makeups")
		public ResponseEntity<Makeup> updateMakeup(@RequestBody Makeup makeup) {
			List<Makeup> makeuplist=makeupService.getAllMakeups();
			for(Makeup makeup1:makeuplist)
			{
				if(makeup1.getName().equals(makeup.getName()))
				{
					makeup1.setName(makeup.getName());
					makeup1.setType(makeup.getType());
					makeup1.setRate(makeup.getRate());
					makeup1.setDescription(makeup.getDescription());
					makeupService.updateMakeup(makeup1);
					return new ResponseEntity<Makeup>(makeup1,HttpStatus.CREATED);
				}
			}
			return new ResponseEntity<Makeup>(HttpStatus.BAD_REQUEST);
		}

		//delete makeup
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@DeleteMapping("/makeups/{makeupid}")
		public ResponseEntity<String> deleteMakeup(@PathVariable int makeupid) {
			boolean status=makeupService.deleteMakeup(makeupid);
			if(status)
				return new ResponseEntity<String>("makeup deleted successfully "+ makeupid,HttpStatus.OK);
			else
				return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
}
