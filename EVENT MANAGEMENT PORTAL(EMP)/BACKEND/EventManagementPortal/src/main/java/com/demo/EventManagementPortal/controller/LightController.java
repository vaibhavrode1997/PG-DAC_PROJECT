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

import com.demo.EventManagementPortal.beans.Light;
import com.demo.EventManagementPortal.beans.PoojaVidhi;
import com.demo.EventManagementPortal.service.LightService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/light")
public class LightController {
	@Autowired(required=false)
	LightService lightService;

	//add light
	@PostMapping("/lights")
	public ResponseEntity<Light> addLight(@RequestBody Light light){
		lightService.addLight(light);
		return new ResponseEntity<Light>(light,HttpStatus.CREATED);
	}	

	//getLight by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/lights/{lightid}")
	public ResponseEntity<Light> getLightById(@PathVariable int lightid) {
		Light light=lightService.getLightById(lightid);
		if(light!=null) {
			return new ResponseEntity(light,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all lights 
	@GetMapping("/lights")
	public ResponseEntity<List<Light>> getAllLights(){
		List<Light> lightlist=lightService.getAllLights();
		return ResponseEntity.ok(lightlist);
	}

	//update light
	@PutMapping("/lights")
	public ResponseEntity<Light> updateLight(@RequestBody Light light) {
		
		List<Light> lightlist=lightService.getAllLights();
		for(Light light1:lightlist)
		{
			if(light1.getName().equals(light.getName()))
			{
				light1.setName(light.getName());
				light1.setType(light.getType());
				light1.setRate(light.getRate());
				light1.setDecoration(light.getDecoration());
				lightService.updateLight(light1);
				return new ResponseEntity<Light>(light1,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<Light>(HttpStatus.BAD_REQUEST);
	}

	//delete light
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/lights/{lightid}")
	public ResponseEntity<String> deleteLight(@PathVariable int lightid) {
		boolean status=lightService.deleteLight(lightid);
		if(status)
			return new ResponseEntity<String>("light deleted successfully "+ lightid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
