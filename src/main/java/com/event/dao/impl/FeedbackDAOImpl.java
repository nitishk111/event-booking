package com.event.dao.impl;

import com.event.dao.FeedbackDAO;
import com.event.model.Feedback;
import com.event.model.Feedback;
import com.event.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FeedbackDAOImpl implements FeedbackDAO {
    @Override
    public String addFeedback(Feedback feedback) {
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            session.persist(feedback);
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return "Feedback Record Added";
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        List<Feedback> feedbacks;
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            TypedQuery<Feedback> query= session.createQuery("Select f from Feedback f",Feedback.class);
            feedbacks = query.getResultList();
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return feedbacks;
    }

    @Override
    public Feedback findFeedbackById(int feedbackId) {
        Feedback feedback;
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            feedback = session.find(Feedback.class, feedbackId);
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return feedback;
    }
}
