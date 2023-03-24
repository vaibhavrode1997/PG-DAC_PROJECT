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
import com.demo.EventManagementPortal.beans.Light;
import com.demo.EventManagementPortal.service.FlowerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/flower")
public class FlowerController {
	@Autowired(required=false)
	FlowerService flowerService;

	//add flower
	@PostMapping("/flowers")
	public ResponseEntity<Flower> addFlower(@RequestBody Flower flower){
		flowerService.addFlower(flower);
		return new ResponseEntity<Flower>(flower,HttpStatus.CREATED);
	}	

	//getflower by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/flowers/{flowerid}")
	public ResponseEntity<Flower> getFlowerById(@PathVariable int flowerid) {
		Flower flower=flowerService.getFlowerById(flowerid);
		if(flower!=null) {
			return new ResponseEntity(flower,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all flowers 
	@GetMapping("/flowers")
	public ResponseEntity<List<Flower>> getAllFlowers(){
		List<Flower> flowerlist=flowerService.getAllFlowers();
		return ResponseEntity.ok(flowerlist);
	}

	//update flower
	@PutMapping("/flowers")
	public ResponseEntity<Flower> updateFlower(@RequestBody Flower flower) {
		List<Flower> flowerlist=flowerService.getAllFlowers();
		for(Flower flower1:flowerlist)
		{
			if(flower1.getName().equals(flower.getName()))
			{
				flower1.setName(flower.getName());
				flower1.setType(flower.getType());
				flower1.setRate(flower.getRate());
				flower1.setDecoration(flower.getDecoration());
				flowerService.updateFlower(flower1);
				return new ResponseEntity<Flower>(flower1,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<Flower>(HttpStatus.BAD_REQUEST);
	}

	//delete flower
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/flowers/{flowerid}")
	public ResponseEntity<String> deleteFlower(@PathVariable int flowerid) {
		boolean status=flowerService.deleteFlower(flowerid);
		if(status)
			return new ResponseEntity<String>("flower deleted successfully "+ flowerid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
