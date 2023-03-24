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

import com.demo.EventManagementPortal.beans.Feedback;
import com.demo.EventManagementPortal.service.FeedbackService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/feedback")
public class FeedbackController {
	@Autowired(required=false)
	FeedbackService feedbackService;

	//add feedback
	@PostMapping("/feedbacks")
	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback){
		feedbackService.addFeedback(feedback);
		return new ResponseEntity<Feedback>(feedback,HttpStatus.CREATED);
	}	

	//getFeedback by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/feedbacks/{feedbackid}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable int feedbackid) {
		Feedback feedback=feedbackService.getFeedbackById(feedbackid);
		if(feedback!=null) {
			return new ResponseEntity(feedback,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all feedbacks 
	@GetMapping("/feedbacks")
	public ResponseEntity<List<Feedback>> getAllFeedbacks(){
		List<Feedback> feedbacklist=feedbackService.getAllFeedbacks();
		return ResponseEntity.ok(feedbacklist);
	}

	//update feedback
	@PutMapping("/feedbacks")
	public ResponseEntity<String> updateFeedback(@RequestBody Feedback feedback) {
		int n=feedbackService.updateFeedback(feedback);
		if(n>0)
			return new ResponseEntity<String>("feedback updated successfully "+feedback,HttpStatus.CREATED);
		else
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	//delete feedback
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/feedbacks/{feedbackid}")
	public ResponseEntity<String> deleteFeedback(@PathVariable int feedbackid) {
		boolean status=feedbackService.deleteFeedback(feedbackid);
		if(status)
			return new ResponseEntity<String>("feedback deleted successfully "+ feedbackid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
