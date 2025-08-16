package com.event.dao;

import com.event.model.Event;
import com.event.model.Registration;
import com.event.model.User;

import java.time.LocalDate;
import java.util.List;

public interface EventDAO {

    public String addEvent(Event event);

    public Event fingEventById(int eventId);
    public List<Event> getAllEvents();
    public List<Event> getUpcomingEvents();

    public List<Event> findByEventTitle(String eventTitle);
    public List<Event> findByEventDate(LocalDate eventDate);
    public List<Event> findByEventLocation(String eventLocation);

    public List<User> findRegisteredUsersOfEvent(int eventId);
    public int findRegisteredNumberOfEvent(int eventId);
    public List<Registration> findAllRegistrationForEvent(Event eventID);


    public double findEventAvgRating(int eventId);


    public String updateEventTitle(int eventId, String eventTitle);
    public String updateEventDate(int eventId, LocalDate eventDate);
    public String updateEventLocation(int eventId, String eventLocation);

    public String deleteEvent(int eventId);

}
