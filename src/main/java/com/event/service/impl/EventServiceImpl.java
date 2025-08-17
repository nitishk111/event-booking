package com.event.service.impl;

import com.event.dao.EventDAO;
import com.event.dao.impl.EventDAOImpl;
import com.event.model.Event;
import com.event.model.Registration;
import com.event.model.User;
import com.event.service.EventService;

import java.time.LocalDate;
import java.util.List;

public class EventServiceImpl implements EventService {

    EventDAO eventDAO;
    public EventServiceImpl(){
        eventDAO = new EventDAOImpl();
    }

    @Override
    public String addEvent(Event event) {
        return eventDAO.addEvent(event);
    }

    @Override
    public Event fingEventById(int eventId) {
        return eventDAO.fingEventById(eventId);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventDAO.getAllEvents();
    }

    @Override
    public List<Event> getUpcomingEvents() {
        return eventDAO.getUpcomingEvents();
    }

    @Override
    public List<Event> findByEventTitle(String eventTitle) {
        return eventDAO.findByEventTitle(eventTitle);
    }

    @Override
    public List<Event> findByEventDate(LocalDate eventDate) {
        return eventDAO.findByEventDate(eventDate);
    }

    @Override
    public List<Event> findByEventLocation(String eventLocation) {
        return eventDAO.findByEventLocation(eventLocation);
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
    public Event updateEventTitle(int eventId, String eventTitle) {
        Event event = eventDAO.fingEventById(eventId);
        event.setEventTitle(eventTitle);
        return eventDAO.updateEvent(event);
    }

    @Override
    public Event updateEventDate(int eventId, LocalDate eventDate) {
        Event event = eventDAO.fingEventById(eventId);
        event.setEventDate(eventDate);
        return eventDAO.updateEvent(event);
    }

    @Override
    public Event updateEventLocation(int eventId, String eventLocation) {
        Event event = eventDAO.fingEventById(eventId);
        event.setEventLocation(eventLocation);
        return eventDAO.updateEvent(event);
    }


    @Override
    public String deleteEvent(int eventId) {
        Event event = eventDAO.fingEventById(eventId);
        return eventDAO.deleteEvent(event);
    }
}
