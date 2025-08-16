package com.event.dao;

import com.event.model.Event;
import com.event.model.Feedback;
import com.event.model.Registration;
import com.event.model.User;

import java.util.List;

public interface UserDAO {

    public String addUser(User user);

    public User findUserById(int userId);
    public User findUserByEmail(String userEmail);
    public List<User> getAllUsers();

    public List<Event> findAllRegisteredEvent(int userId);
    public List<Feedback> findAllFeedback(int userId);
    public List<Registration> findAllRegistrationByUser(User userID);

    public List<Event> findAllNonRegisteredEvents(int userId);

    public boolean authenticateUser(String userEmail, String userPassword);

    public String updateEmail(int userId, String userEmail);
    public String updateName(int userId, String userName);
    public String updatePassword(int userId, String userPassword);

    public String changeFeedbackRating(int feedbackId, int feedbackRating);
    public String changeFeedbackComment(int feedbackId, String feedbackComment);

    public String deleteFeedback(int feedbackId);

    public String deleteUser(int userId);

}
