package com.automation.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automation.entity.Customer;
import com.automation.entity.Feedback;
import com.automation.service.FeedbackService;
import com.automation.service.FeedbackServiceImpl;
@RestController
@RequestMapping("/Feedback")
public class FeedbackController {
	
	
	private final org.slf4j.Logger mylogs = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private  FeedbackService feedbackService;

 // http://localhost:8090/Feedback/addFeedback
 	@PostMapping("/addFeedback")
 	public Feedback addFeedback(@RequestBody Feedback feedback) {
 		try {
 			return feedbackService.addFeedback(feedback);
 		} catch (Exception e) {

 			e.printStackTrace();
 		}
 		return feedback;
 	}

 	// http://localhost:8090/Feedback/delete
 	@DeleteMapping("/deleteFeedback/{fId}")
 	public String deleteFeedbackByfId(@PathVariable int fId) {
 		try {
 			// Assuming routeService.deleteCustomerBycId(cId) method exists to perform the
 			// delete operation
 			feedbackService.deleteFeedbackByfId(fId);
 			mylogs.info("Deleted = " + fId + " Data");
 			return "Deleted Id = " + fId + " Data";
 		} catch (Exception e) {
 			e.printStackTrace();
 			return "Error deleting Id = " + fId + " Data: " + e.getMessage();
 		}
 	}

 	// http://localhost:8090/Feedback/updateFeedback
 	@PutMapping("/updateFeedback/{fId}")

 	public Feedback updateFeedback(@PathVariable int fId, @RequestBody Feedback feedback) throws Exception {

 		feedback.setfId(fId);

 		return feedbackService.updateFeedback(feedback);

 	}

 	// http://localhost:8090/Feedback/allFeedback
 	@GetMapping("/allFeedback")
 	public List<Feedback> viewAllFeedback() throws Exception {
 		return feedbackService.viewAllFeedback();
 	}

 	// http://localhost:8090/Feedback/feedbackId/2
 	@GetMapping("/feedbackId/{fId}")
 	public Feedback getFeedbackByfId(@PathVariable int fId) {
 		Feedback feedback = feedbackService.getFeedbackByfId(fId);
 		return (feedback != null) ? feedback : new Feedback(); // Return an empty Booking object if not found
 	}


}
