package com.automation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automation.entity.Customer;
import com.automation.entity.Feedback;
import com.automation.repository.CustomerRepository;
import com.automation.repository.FeedbackRepository;
@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackRepository feedbackRepo;
	// You might want to replace this with a database or repository
	// for the actual storage and retrieval of customer data
	private List<Feedback> feedback = new ArrayList<>();

	@Override
	public Feedback addFeedback(Feedback feedback) {
		return feedbackRepo.save(feedback);
	}

	@Override
	public Feedback getFeedbackByfId(int fId) {
		
		    return feedbackRepo.findById(fId).orElse(null);
		}

	@Override
      public Feedback updateFeedback(Feedback feedback) throws Exception {
		Feedback existingFeedback = feedbackRepo.findById(feedback.getfId())
				.orElseThrow(() -> new Exception("Feedback not found"));
		existingFeedback.setcId(feedback.getcId());
		existingFeedback.setfId(feedback.getfId());
		existingFeedback.setdId(feedback.getdId());
		existingFeedback.setRating(feedback.getRating());
		existingFeedback.setComments(feedback.getComments());
		return feedbackRepo.save(existingFeedback);

	}

	@Override
	public void deleteFeedbackByfId(int fId) {
		feedbackRepo.deleteById(fId);

	}

	@Override
	public List<Feedback> viewAllFeedback() {
		List<Feedback> allFeedback = feedbackRepo.findAll(); // Note : same as save
		return allFeedback;
	}
}
