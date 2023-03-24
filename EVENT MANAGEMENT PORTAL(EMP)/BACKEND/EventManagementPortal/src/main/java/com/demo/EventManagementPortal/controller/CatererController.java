package com.demo.EventManagementPortal.controller;

import java.util.List;
import java.util.Optional;

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
import com.demo.EventManagementPortal.beans.Caterer;
import com.demo.EventManagementPortal.beans.Hall;
import com.demo.EventManagementPortal.service.CatererService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/caterer")
public class CatererController {
	
	@Autowired(required=false)
	CatererService catererService;

	//add caterer
	@PostMapping("/caterers")
	public ResponseEntity<Caterer> addCaterer(@RequestBody Caterer caterer){
		catererService.addCaterer(caterer);
		return new ResponseEntity<Caterer>(caterer,HttpStatus.CREATED);
	}	

	//getCaterer by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/caterers/{catererid}")
	public ResponseEntity<Caterer> getCatererById(@PathVariable int catererid) {
		Caterer caterer=catererService.getCatererById(catererid);
		if(caterer!=null) {
			return new ResponseEntity(caterer,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all caterers 
	@GetMapping("/caterers")
	public ResponseEntity<List<Caterer>> getAllCaterers(){
		List<Caterer> catererlist=catererService.getAllCaterers();
		return ResponseEntity.ok(catererlist);
	}

	//update caterer
	@PutMapping("/caterers")
	public ResponseEntity<Caterer> updateCaterer(@RequestBody Caterer caterer) {
		
		List<Caterer> catererlist=catererService.getAllCaterers();
		for(Caterer caterer1:catererlist)
		{
			if(caterer1.getName().equals(caterer.getName()))
			{
				caterer1.setCapacity(caterer.getCapacity());
				caterer1.setDescription(caterer.getDescription());
				caterer1.setItem(caterer.getItem());
				caterer1.setName(caterer.getName());
				caterer1.setRate(caterer.getRate());
				catererService.updateCaterer(caterer1);
				return new ResponseEntity<Caterer>(caterer1,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<Caterer>(HttpStatus.BAD_REQUEST);
	}

	//delete caterer
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/caterers/{catererid}")
	public ResponseEntity<String> deleteCaterer(@PathVariable int catererid) {
		boolean status=catererService.deleteCaterer(catererid);
		if(status)
			return new ResponseEntity<String>("caterer deleted successfully "+catererid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
