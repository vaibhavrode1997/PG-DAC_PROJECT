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
import com.demo.EventManagementPortal.beans.Transportation;
import com.demo.EventManagementPortal.service.FireCrackersService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/firecracker")
public class FireCrackersController {
	@Autowired(required=false)
	FireCrackersService fireCrackersService;

	//add fireCracker
	@PostMapping("/firecrackers")
	public ResponseEntity<FireCrackers> addFireCracker(@RequestBody FireCrackers fireCrackers){
		fireCrackersService.addFireCrackers(fireCrackers);
		return new ResponseEntity<FireCrackers>(fireCrackers,HttpStatus.CREATED);
	}	

	//getFireCracker by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/firecrackers/{firecrackersid}")
	public ResponseEntity<FireCrackers> getFireCrackersById(@PathVariable int firecrackersid) {
		FireCrackers service=fireCrackersService.getFireCrackersById(firecrackersid);
		if(service!=null) {
			return new ResponseEntity(service,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all fireCrackers 
	@GetMapping("/firecrackers")
	public ResponseEntity<List<FireCrackers>> getAllFireCracker(){
		List<FireCrackers> fireCrackerslist=fireCrackersService.getAllFireCrackers();
		return ResponseEntity.ok(fireCrackerslist);
	}

	//update fireCracker
	@PutMapping("/fireCrackers")
	public ResponseEntity<FireCrackers> updateFireCracker(@RequestBody FireCrackers fireCrackers) {
		List<FireCrackers> fireCrackerslist=fireCrackersService.getAllFireCrackers();
		for(FireCrackers fireCrackers1:fireCrackerslist)
		{
			if(fireCrackers1.getName().equals(fireCrackers.getName()))
			{
				fireCrackers1.setName(fireCrackers.getName());
				fireCrackers1.setType(fireCrackers.getType());
				fireCrackers1.setRate(fireCrackers.getRate());
				fireCrackers1.setDescription(fireCrackers.getDescription());
				fireCrackersService.updateFireCrackers(fireCrackers1);
				return new ResponseEntity<FireCrackers>(fireCrackers1,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<FireCrackers>(HttpStatus.BAD_REQUEST);
	}

	//delete fireCrackers
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/firecrackers/{firecrackersid}")
	public ResponseEntity<String> deleteFireCracker(@PathVariable int firecrackersid) {
		boolean status=fireCrackersService.deleteFireCrackers(firecrackersid);
		if(status)
			return new ResponseEntity<String>("fireCrackers deleted successfully "+firecrackersid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
