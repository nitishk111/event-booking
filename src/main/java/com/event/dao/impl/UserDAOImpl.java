package com.event.dao.impl;

import com.event.dao.UserDAO;
import com.event.model.Event;
import com.event.model.Feedback;
import com.event.model.Registration;
import com.event.model.User;
import com.event.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOImpl implements UserDAO {


    @Override
    public String addUser(User user) {

        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            session.persist(user);
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return "User Record Added";
    }

    @Override
    public User findUserById(int userId) {
        User user;
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            user = session.find(User.class, userId);
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return user;
    }

    @Override
    public User findUserByEmail(String userEmail) {
        User user;
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            user = session.find(User.class, userEmail);
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
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
    public boolean authenticateUser(String userEmail, String userPassword) {
        return false;
    }

    @Override
    public String updateEmail(int userId, String userEmail) {
        return "";
    }

    @Override
    public String updateName(int userId, String userName) {
        return "";
    }

    @Override
    public String updatePassword(int userId, String userPassword) {
        return "";
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
    public String deleteUser(int userId) {
        return "";
    }
}
