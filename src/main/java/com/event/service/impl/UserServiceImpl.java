package com.event.service.impl;

import com.event.dao.UserDAO;
import com.event.dao.impl.UserDAOImpl;
import com.event.model.Event;
import com.event.model.Feedback;
import com.event.model.Registration;
import com.event.model.User;
import com.event.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDAO userDAO;
    public UserServiceImpl(){
        userDAO = new UserDAOImpl();
    }
    @Override
    public String addUser(User user) {

        try{
            userDAO.findUserByEmail(user.getUserEmail());
        } catch (Exception e) {
            userDAO.addUser(user);
            return "Record Added";
        }
        return "User Already Exists.";
    }

    @Override
    public User findUserById(int userId) {
        return userDAO.findUserById(userId);
    }

    @Override
    public User findUserByEmail(String userEmail) {
        return userDAO.findUserByEmail(userEmail);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public List<Event> findAllRegisteredEvent(int userId) {
        return null;
    }

    @Override
    public List<Feedback> findAllFeedback(int userId) {
        return null;
    }

    @Override
    public List<Registration> findAllRegistrationByUser(User userID) {
        return null;
    }

    @Override
    public List<Event> findAllNonRegisteredEvents(int userId) {
        return null;
    }

    @Override
    public User authenticateUser(String userEmail, String userPassword) {
        try{
            userDAO.findUserByEmail(userEmail);
            return userDAO.authenticateUser(userEmail, userPassword);
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public User updateUserName(String userEmail, String userPassword, String updatedName) {
        try{
            User user= userDAO.authenticateUser(userEmail, userPassword);
            user.setUserName(updatedName);
            return userDAO.updateUser(user);
        }catch (Exception e){
            throw e;
        }

    }
    @Override
    public User updateUserEmail(String userEmail, String userPassword, String updatedEmail) {
        try{
            User user=userDAO.authenticateUser(userEmail, userPassword);
            user.setUserEmail(updatedEmail);
            return userDAO.updateUser(user);
        }catch (Exception e){
            throw e;
        }
    }
    @Override
    public User updatePassword(String userEmail, String userPassword, String updatedPassword) {
        try{
            User user= userDAO.authenticateUser(userEmail, userPassword);
            user.setUserPassword(updatedPassword);
            return userDAO.updateUser(user);
        }catch (Exception e){
            throw e;
        }
    }


    @Override
    public String changeFeedbackRating(int feedbackId, int feedbackRating) {
        return "";
    }

    @Override
    public String changeFeedbackComment(int feedbackId, String feedbackComment) {
        return "";
    }

    @Override
    public String deleteFeedback(int feedbackId) {
        return "";
    }

    @Override
    public String deleteUser(String userEmail, String userPassword) {
        User user= userDAO.authenticateUser(userEmail, userPassword);
        return userDAO.deleteUser(user);
    }


}
