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
import com.demo.EventManagementPortal.beans.Transportation;
import com.demo.EventManagementPortal.beans.WaterSupply;
import com.demo.EventManagementPortal.service.TransportationService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/transportation")
public class TransportationController {
	
	@Autowired(required=false)
	TransportationService transportationService;

	//add transportation
	@PostMapping("/transportations")
	public ResponseEntity<Transportation> addTransportation(@RequestBody Transportation transportation){
		transportationService.addTransportation(transportation);
		return new ResponseEntity<Transportation>(transportation,HttpStatus.CREATED);
	}	

	//getTransportation by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/transportations/{transportationid}")
	public ResponseEntity<Transportation> getTransportationById(@PathVariable int transportationid) {
		Transportation service=transportationService.getTransportationById(transportationid);
		if(service!=null) {
			return new ResponseEntity(service,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all transportations 
	@GetMapping("/transportations")
	public ResponseEntity<List<Transportation>> getAllTransportations(){
		List<Transportation> transportationlist=transportationService.getAllTransportations();
		return ResponseEntity.ok(transportationlist);
	}

	//update Transportation
	@PutMapping("/transportations")
	public ResponseEntity<Transportation> updateTransportation(@RequestBody Transportation transportation) {
		
		List<Transportation> transportationlist=transportationService.getAllTransportations();
		for(Transportation transportation1:transportationlist)
		{
			if(transportation1.getName().equals(transportation.getName()))
			{
				transportation1.setName(transportation.getName());
				transportation1.setType(transportation.getType());
				transportation1.setRate(transportation.getRate());
				transportation1.setDescription(transportation.getDescription());
				transportationService.updateTransportation(transportation1);
				return new ResponseEntity<Transportation>(transportation1,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<Transportation>(HttpStatus.BAD_REQUEST);
	}

	//delete transportation
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/transportations/{transportationid}")
	public ResponseEntity<String> deleteTransportation(@PathVariable int transportationid) {
		boolean status=transportationService.deleteTransportation(transportationid);
		if(status)
			return new ResponseEntity<String>("transportation deleted successfully "+ transportationid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}
