package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.Feedback;
import com.demo.EventManagementPortal.dao.FeedbackDao;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired(required=false)
	FeedbackDao feedbackDao;
	
	//add feedback
	@Override
	public void addFeedback(Feedback feedback) {
		feedbackDao.save(feedback);
	}

	//getFeedback by id
	@Override
	public Feedback getFeedbackById(int feedbackid) {
		Optional<Feedback> op=feedbackDao.findById(feedbackid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all feedbacks 
	@Override
	public List<Feedback> getAllFeedbacks() {
		return feedbackDao.findAll();
	}

	//get all feedbacks 
	@Override
	public int updateFeedback(Feedback feedback) {
		Optional<Feedback> op=feedbackDao.findById(feedback.getFeedbackid());
		if(op.isPresent()) {
			Feedback feedback1=op.get();
			feedback1.setEmail(feedback.getEmail());
			feedback1.setSubject(feedback.getSubject());
			feedback1.setMessage(feedback.getMessage());
			feedbackDao.save(feedback1);
			return 1;
		}
		return 0;
	}

	//delete feedback
	@Override
	public boolean deleteFeedback(int feedbackid) {
		Optional<Feedback> op=feedbackDao.findById(feedbackid);
		if(op.isPresent()) {
			feedbackDao.deleteById(feedbackid);
			return true;
		}
		return false;
	}
}
