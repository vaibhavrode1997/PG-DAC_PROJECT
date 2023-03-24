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
import com.demo.EventManagementPortal.beans.Musicsystem;
import com.demo.EventManagementPortal.service.MusicsystemService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/musicsystem")
public class MusicsystemController {
	@Autowired(required=false)
	MusicsystemService musicsystemService;

	//add Musicsystem
	@PostMapping("/musicsystems")
	public ResponseEntity<Musicsystem> addMusicsystem(@RequestBody Musicsystem musicsystem){
		musicsystemService.addMusicsystem(musicsystem);
		return new ResponseEntity<Musicsystem>(musicsystem,HttpStatus.CREATED);
	}	

	//getMusicsystem by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/musicsystems/{musicsystemid}")
	public ResponseEntity<Musicsystem> getMusicsystemById(@PathVariable int musicsystemid) {
		Musicsystem service=musicsystemService.getMusicsystemById(musicsystemid);
		if(service!=null) {
			return new ResponseEntity(service,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all musicsystems 
	@GetMapping("/musicsystems")
	public ResponseEntity<List<Musicsystem>> getAllMusicsystem(){
		List<Musicsystem> musicsystemlist=musicsystemService.getAllMusicsystem();
		return ResponseEntity.ok(musicsystemlist);
	}

	//update Musicsystem
	@PutMapping("/musicsystems")
	public ResponseEntity<Musicsystem> updatemusicsystem(@RequestBody Musicsystem musicsystem) {
		List<Musicsystem> musicsystemlist=musicsystemService.getAllMusicsystem();
		for(Musicsystem musicsystem1:musicsystemlist)
		{
			if(musicsystem1.getMusicsystemname().equals(musicsystem.getMusicsystemname()))
			{
				musicsystem1.setMusicsystemname(musicsystem.getMusicsystemname());
				musicsystem1.setRate(musicsystem.getRate());
				musicsystem1.setDescription(musicsystem.getDescription());
				musicsystemService.updateMusicsystem(musicsystem1);
				return new ResponseEntity<Musicsystem>(musicsystem1,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<Musicsystem>(HttpStatus.BAD_REQUEST);
	}

	//delete musicsystem
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/musicsystems/{musicsystemid}")
	public ResponseEntity<String> deleteEvent(@PathVariable int musicsystemid) {
		boolean status=musicsystemService.deleteMusicsystem(musicsystemid);
		if(status)
			return new ResponseEntity<String>("musicsystem deleted successfully "+ musicsystemid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
