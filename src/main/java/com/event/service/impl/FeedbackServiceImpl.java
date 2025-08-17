package com.event.service.impl;

import com.event.dao.FeedbackDAO;
import com.event.dao.impl.FeedbackDAOImpl;
import com.event.model.Feedback;
import com.event.service.FeedbackService;

import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {

    FeedbackDAO feedbackDAO;
    public FeedbackServiceImpl(){
        feedbackDAO= new FeedbackDAOImpl();
    }
    @Override
    public String addFeedback(Feedback feedback) {
        return feedbackDAO.addFeedback(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackDAO.getAllFeedbacks();
    }

    @Override
    public Feedback findFeedbackById(int feedbackId) {
        return feedbackDAO.findFeedbackById(feedbackId);
    }
}
