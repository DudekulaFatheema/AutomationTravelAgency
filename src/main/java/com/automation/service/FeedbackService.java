package com.automation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.automation.entity.Customer;
import com.automation.entity.Feedback;
@Service
public interface FeedbackService {

	   // Create
    public Feedback addFeedback(Feedback feedback);
    
    // Read
    public Feedback getFeedbackByfId(int fId);
    
    // Update
    public  Feedback updateFeedback(Feedback feedback) throws Exception;
    
    // Delete
    public void deleteFeedbackByfId(int fId);

	public List<Feedback> viewAllFeedback();
}
