package com.event.dao;

import com.event.model.Feedback;

import java.util.List;

public interface FeedbackDAO {

    public String addFeedback(Feedback feedback);

    public List<Feedback> getAllFeedbacks();
    public Feedback findFeedbackById(int feedbackId);


}
