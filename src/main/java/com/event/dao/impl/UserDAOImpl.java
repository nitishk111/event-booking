package com.event.dao.impl;

import com.event.dao.UserDAO;
import com.event.model.Event;
import com.event.model.Feedback;
import com.event.model.Registration;
import com.event.model.User;
import com.event.util.HibernateUtil;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.TypedQuery;
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
            TypedQuery<User> query= session.createQuery("FROM User u WHERE u.userEmail =:email", User.class);
            query.setParameter("email", userEmail);
            user = query.getSingleResult();
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users;
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            TypedQuery<User> query= session.createQuery("Select u from User u",User.class);
            users = query.getResultList();
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return users;
    }

    @Override
    public List<Event> findAllRegisteredEvent(int userId) {
//        List<Event> events;
//        try(Session session = HibernateUtil.getSession()){
//            Transaction tx= session.beginTransaction();
//            TypedQuery<Event> query= session.createQuery("Select u from User u",Event.class);
//            events = query.getResultList();
//            tx.commit();
//        }catch (Exception e){
//            throw e;
//        }
//        return events;
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
        User authUser;
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            TypedQuery<User> query= session.createQuery("FROM User u WHERE u.userEmail= :email AND u.userPassword= :pass", User.class);
            query.setParameter("email", userEmail);
            query.setParameter("pass", userPassword);
            authUser =(User) query.getSingleResult();
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return authUser;
    }

    @Override
    public User updateUser(User user) {
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            User updatedUser = session.merge(user);
            tx.commit();
            return updatedUser;
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
    public String deleteUser(User user) {
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            session.remove(user);
            tx.commit();
            return "User Removed";
        }catch (Exception e){
            throw e;
        }
    }
}
