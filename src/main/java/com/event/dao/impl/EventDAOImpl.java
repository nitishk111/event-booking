package com.event.dao.impl;

import com.event.dao.EventDAO;
import com.event.model.Event;
import com.event.model.Registration;
import com.event.model.User;
import com.event.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class EventDAOImpl implements EventDAO {
    @Override
    public String addEvent(Event event) {
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            session.persist(event);
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return "Event Record Added";
    }

    @Override
    public Event fingEventById(int eventId) {
        Event event;
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            event = session.find(Event.class, eventId);
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> events;
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            TypedQuery<Event> query= session.createQuery("Select e from Event e",Event.class);
            events = query.getResultList();
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return events;
    }

    @Override
    public List<Event> getUpcomingEvents() {
        List<Event> events;
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            TypedQuery<Event> query= session.createQuery("Select e from Event e WHERE e.eventDate >=: date",Event.class);
            query.setParameter("date", LocalDate.now());
            events = query.getResultList();
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return events;
    }

    @Override
    public List<Event> findByEventTitle(String eventTitle) {
        List<Event> events;
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            TypedQuery<Event> query= session.createQuery("FROM Event e WHERE e.eventTitle =:title", Event.class);
            query.setParameter("event", eventTitle);
            events = query.getResultList();
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return events;
    }

    @Override
    public List<Event> findByEventDate(LocalDate eventDate) {
        List<Event> events;
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            TypedQuery<Event> query= session.createQuery("FROM Event e WHERE e.eventDate =:date", Event.class);
            query.setParameter("date", eventDate);
            events = query.getResultList();
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return events;
    }

    @Override
    public List<Event> findByEventLocation(String eventLocation) {
        List<Event> events;
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            TypedQuery<Event> query= session.createQuery("FROM Event e WHERE e.eventLocation =:location", Event.class);
            query.setParameter("location", eventLocation);
            events = query.getResultList();
            tx.commit();
        }catch (Exception e){
            throw e;
        }
        return events;
    }

    @Override
    public List<User> findRegisteredUsersOfEvent(int eventId) {
        return null;
    }

    @Override
    public int findRegisteredNumberOfEvent(int eventId) {
        return 0;
    }

    @Override
    public List<Registration> findAllRegistrationForEvent(Event eventID) {
        return null;
    }

    @Override
    public double findEventAvgRating(int eventId) {
        return 0;
    }

    @Override
    public Event updateEvent(Event event) {
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            Event updatedEvent = session.merge(event);
            tx.commit();
            return updatedEvent;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public String deleteEvent(Event event){
        try(Session session = HibernateUtil.getSession()){
            Transaction tx= session.beginTransaction();
            session.remove(event);
            tx.commit();
            return "Event Removed";
        }catch (Exception e){
            throw e;
        }
    }
}
