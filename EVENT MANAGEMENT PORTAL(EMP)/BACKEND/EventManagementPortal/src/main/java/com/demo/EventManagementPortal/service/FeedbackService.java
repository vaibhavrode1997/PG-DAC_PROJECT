package com.demo.EventManagementPortal.service;
import java.util.List;
import com.demo.EventManagementPortal.beans.Feedback;

public interface FeedbackService {
	//add feedback
	void addFeedback(Feedback feedback);

	//getFeedback by id
	Feedback getFeedbackById(int feedbackid);

	//get all feedbacks 
	List<Feedback> getAllFeedbacks();

	//get all feedbacks 
	int updateFeedback(Feedback feedback);

	//delete feedback
	boolean deleteFeedback(int feedbackid);
}
