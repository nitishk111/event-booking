package com.event.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Entity")
@Table(
        name="event_details",
        uniqueConstraints ={
                @UniqueConstraint( columnNames = {"event_date","event_location"})
        }
)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_id")
    private int eventId;

    @Column(name="event_title" ,nullable = false)
    private String eventTitle;

    @Column(name="event_date",nullable = false)
    private LocalDate eventDate;

    @Column(name="event_location",nullable = false)
    private String eventLocation;

    public Event() {
    }

    public Event(String eventTitle, LocalDate eventDate, String eventLocation) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventTitle='" + eventTitle + '\'' +
                ", eventDate=" + eventDate +
                ", eventLocation='" + eventLocation + '\'' +
                '}';
    }
}
