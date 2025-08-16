package com.event.model;

import com.event.util.FeedbackRating;
import jakarta.persistence.*;

@Entity
@Table(name= "feedback_details")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;

    @OneToOne
    private Registration feedbackRegistration;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FeedbackRating feedbackRating;

    @Column(nullable = false)
    private String feedbackComments;

    public Feedback(){
    }

    public Feedback(int feedbackId, Registration feedbackRegistration, FeedbackRating feedbackRating, String feedbackComments) {
        this.feedbackId = feedbackId;
        this.feedbackRegistration = feedbackRegistration;
        this.feedbackRating = feedbackRating;
        this.feedbackComments = feedbackComments;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Registration getFeedbackRegistration() {
        return feedbackRegistration;
    }

    public void setFeedbackRegistration(Registration feedbackRegistration) {
        this.feedbackRegistration = feedbackRegistration;
    }

    public FeedbackRating getFeedbackRating() {
        return feedbackRating;
    }

    public void setFeedbackRating(FeedbackRating feedbackRating) {
        this.feedbackRating = feedbackRating;
    }

    public String getFeedbackComments() {
        return feedbackComments;
    }

    public void setFeedbackComments(String feedbackComments) {
        this.feedbackComments = feedbackComments;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", feedbackRegistration=" + feedbackRegistration +
                ", feedbackRating=" + feedbackRating +
                ", feedbackComments='" + feedbackComments + '\'' +
                '}';
    }
}

