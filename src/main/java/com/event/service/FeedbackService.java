package com.event.service;

import com.event.model.Feedback;

import java.util.List;

public interface FeedbackService {

    public String addFeedback(Feedback feedback);

    public List<Feedback> getAllFeedbacks();
    public Feedback findFeedbackById(int feedbackId);

}
