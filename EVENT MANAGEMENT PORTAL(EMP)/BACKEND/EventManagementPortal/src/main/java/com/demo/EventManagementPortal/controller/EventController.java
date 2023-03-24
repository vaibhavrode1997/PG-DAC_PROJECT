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
import com.demo.EventManagementPortal.beans.Event;
import com.demo.EventManagementPortal.service.EventService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/event")
public class EventController
{
	@Autowired(required=false)
	EventService eventService;

	//add event
	@PostMapping("/events")
	public ResponseEntity<Event> addEvent(@RequestBody Event event){
		eventService.addEvent(event);
		return new ResponseEntity<Event>(event,HttpStatus.CREATED);
	}	

	//getEvent by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/events/{eventid}")
	public ResponseEntity<Event> getEventById(@PathVariable int eventid) {
		Event event=eventService.getEventById(eventid);
		if(event!=null) {
			return new ResponseEntity(event,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all events 
	@GetMapping("/events")
	public ResponseEntity<List<Event>> getAllEvents(){
		List<Event> eventlist=eventService.getAllEvents();
		return ResponseEntity.ok(eventlist);
	}

	//update Event
	@PutMapping("/events")
	public ResponseEntity<String> updateEvent(@RequestBody Event event) {
		int n=eventService.updateEvent(event);
		if(n>0)
			return new ResponseEntity<String>("event updated successfully "+event,HttpStatus.CREATED);
		else
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	//delete event
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/events/{eventid}")
	public ResponseEntity<String> deleteEvent(@PathVariable int eventid) {
		boolean status=eventService.deleteEvent(eventid);
		if(status)
			return new ResponseEntity<String>("event deleted successfully "+ eventid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
