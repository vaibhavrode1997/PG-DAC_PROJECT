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
import com.demo.EventManagementPortal.beans.Photography;
import com.demo.EventManagementPortal.service.PhotographyService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/photography")
public class PhotographyController {
	@Autowired(required=false)
	PhotographyService photographyService;

	//add photography
	@PostMapping("/photographys")
	public ResponseEntity<Photography> addPhotography(@RequestBody Photography photography){
		photographyService.addPhotography(photography);
		return new ResponseEntity<Photography>(photography,HttpStatus.CREATED);
	}	

	//getPhotography by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/photographys/{photographyid}")
	public ResponseEntity<Photography> getPhotographyById(@PathVariable int photographyid) {
		Photography service=photographyService.getPhotographyById(photographyid);
		if(service!=null) {
			return new ResponseEntity(service,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all photography 
	@GetMapping("/photographys")
	public ResponseEntity<List<Photography>> getAllPhotography(){
		List<Photography> photographylist=photographyService.getAllPhotography();
		return ResponseEntity.ok(photographylist);
	}

	//update photography
	@PutMapping("/photographys")
	public ResponseEntity<Photography> updatePhotography(@RequestBody Photography photography) {
		
		List<Photography> photographylist=photographyService.getAllPhotography();
		for(Photography photography1:photographylist)
		{
			if(photography1.getName().equals(photography.getName()))
			{
				photography1.setName(photography.getName());
				photography1.setType(photography.getType());
				photography1.setRate(photography.getRate());
				photography1.setDescription(photography.getDescription());
				photographyService.updatePhotography(photography1);
				return new ResponseEntity<Photography>(photography1,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<Photography>(HttpStatus.BAD_REQUEST);
	}

	//delete photography
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/photographys/{photographyid}")
	public ResponseEntity<String> deleteEvent(@PathVariable int photographyid) {
		boolean status=photographyService.deletePhotography(photographyid);
		if(status)
			return new ResponseEntity<String>("photography deleted successfully "+ photographyid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
