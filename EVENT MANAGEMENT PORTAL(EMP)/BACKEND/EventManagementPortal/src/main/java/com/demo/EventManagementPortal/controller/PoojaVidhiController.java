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

import com.demo.EventManagementPortal.beans.Horse;
import com.demo.EventManagementPortal.beans.PoojaVidhi;
import com.demo.EventManagementPortal.service.PoojaVidhiService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/poojavidhi")
public class PoojaVidhiController {
	@Autowired(required=false)
	PoojaVidhiService poojavidhiService;

	//add poojaVidhi
	@PostMapping("/poojavidhis")
	public ResponseEntity<PoojaVidhi> addPoojaVidhi(@RequestBody PoojaVidhi poojavidhi){
		poojavidhiService.addPoojaVidhi(poojavidhi);
		return new ResponseEntity<PoojaVidhi>(poojavidhi,HttpStatus.CREATED);
	}	

	//getPoojaVidhi by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/poojavidhis/{poojavidhiid}")
	public ResponseEntity<PoojaVidhi> getPoojaVidhiById(@PathVariable int poojavidhiid) {
		PoojaVidhi service=poojavidhiService.getPoojaVidhiById(poojavidhiid);
		if(service!=null) {
			return new ResponseEntity(service,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all poojaVidhis 
	@GetMapping("/poojavidhis")
	public ResponseEntity<List<PoojaVidhi>> getAllPoojaVidhi(){
		List<PoojaVidhi> poojavidhilist=poojavidhiService.getAllPoojaVidhi();
		return ResponseEntity.ok(poojavidhilist);
	}

	//update PoojaVidhi
	@PutMapping("/poojavidhis")
	public ResponseEntity<PoojaVidhi> updatePoojaVidhi(@RequestBody PoojaVidhi poojavidhi) {
		List<PoojaVidhi> poojavidhilist=poojavidhiService.getAllPoojaVidhi();
		for(PoojaVidhi poojavidhi1:poojavidhilist)
		{
			if(poojavidhi1.getName().equals(poojavidhi.getName()))
			{
				poojavidhi1.setName(poojavidhi.getName());
				poojavidhi1.setType(poojavidhi.getType());
				poojavidhi1.setRate(poojavidhi.getRate());
				poojavidhi1.setDescription(poojavidhi.getDescription());
				poojavidhiService.updatePoojaVidhi(poojavidhi1);
				return new ResponseEntity<PoojaVidhi>(poojavidhi1,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<PoojaVidhi>(HttpStatus.BAD_REQUEST);
	}

	//delete poojaVidhi
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/poojavidhis/{poojavidhiid}")
	public ResponseEntity<String> deletePoojaVidhi(@PathVariable int poojavidhiid) {
		boolean status=poojavidhiService.deletePoojaVidhi(poojavidhiid);
		if(status)
			return new ResponseEntity<String>("poojaVidhi deleted successfully "+ poojavidhiid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}
