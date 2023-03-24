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

import com.demo.EventManagementPortal.beans.Photography;
import com.demo.EventManagementPortal.beans.WaterSupply;
import com.demo.EventManagementPortal.service.WaterSupplyService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/watersupply")
public class WaterSupplyController {
	@Autowired(required=false)
	WaterSupplyService waterSupplyService;

	//add waterSupply
	@PostMapping("/watersupplys")
	public ResponseEntity<WaterSupply> addWaterSupply(@RequestBody WaterSupply waterSupply){
		waterSupplyService.addWaterSupply(waterSupply);
		return new ResponseEntity<WaterSupply>(waterSupply,HttpStatus.CREATED);
	}	

	//getWaterSupply by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/watersupplys/{watersupplyid}")
	public ResponseEntity<WaterSupply> getWaterSupplyById(@PathVariable int waterSupplyid) {
		WaterSupply service=waterSupplyService.getWaterSupplyById(waterSupplyid);
		if(service!=null) {
			return new ResponseEntity(service,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all waterSupplys 
	@GetMapping("/watersupplys")
	public ResponseEntity<List<WaterSupply>> getAllWaterSupplys(){
		List<WaterSupply> waterSupplylist=waterSupplyService.getAllWaterSupply();
		return ResponseEntity.ok(waterSupplylist);
	}

	//update waterSupply
	@PutMapping("/watersupplys")
	public ResponseEntity<WaterSupply> updateWaterSupply(@RequestBody WaterSupply waterSupply) {
		List<WaterSupply> waterSupplylist=waterSupplyService.getAllWaterSupply();
		for(WaterSupply waterSupply1:waterSupplylist)
		{
			if(waterSupply1.getName().equals(waterSupply.getName()))
			{
				waterSupply1.setName(waterSupply.getName());
				waterSupply1.setQuantity(waterSupply.getQuantity());
				waterSupply1.setRate(waterSupply.getRate());
				waterSupply1.setDescription(waterSupply.getDescription());
				waterSupplyService.updateWaterSupply(waterSupply1);
				return new ResponseEntity<WaterSupply>(waterSupply1,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<WaterSupply>(HttpStatus.BAD_REQUEST);
	}

	//delete waterSupply
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/watersupplys/{watersupplyid}")
	public ResponseEntity<String> deleteWaterSupply(@PathVariable int waterSupplyid) {
		boolean status=waterSupplyService.deleteWaterSupply(waterSupplyid);
		if(status)
			return new ResponseEntity<String>("WaterSupply deleted successfully "+ waterSupplyid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
