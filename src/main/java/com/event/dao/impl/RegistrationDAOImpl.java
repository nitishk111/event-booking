package com.event.dao.impl;

import com.event.dao.RegistrationDAO;
import com.event.model.Registration;
import com.event.util.HibernateUtil;
import com.event.util.RegistrationStatus;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {
    @Override
    public String registerUser(Registration registration) {
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            session.persist(registration);
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return "Registration Done";
    }

    @Override
    public Registration findRegistrationById(int registrationId) {
        Registration registration;
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            registration = session.find(Registration.class, registrationId);
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return registration;
    }

    @Override
    public List<Registration> getAllRegistration() {
        List<Registration> registrations;
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            TypedQuery<Registration> query= session.createQuery("Select r FROM Registration r",Registration.class);
            registrations = query.getResultList();
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return registrations;
    }

    @Override
    public String markAttendence(int registrationId) {
        try(Session session= HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            TypedQuery<Registration> query =session.createQuery("UPDATE Registration SET registrationStatus= :regStatus WHERE registrationId= :regId ");
            query.setParameter("regStatus", RegistrationStatus.ATTENDED);
            query.setParameter("regId", registrationId);
            query.executeUpdate();
            tx.commit();
        }
        return "User Attended Event";
    }

    @Override
    public String deRegisterForEvent(Registration registration) {
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            session.remove(registration);
            tx.commit();
            return "User Deregistered";
        }catch (Exception e){
            throw e;
        }
    }
}
