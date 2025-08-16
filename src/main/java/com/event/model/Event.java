package com.event.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(
        name="event_details",
        uniqueConstraints ={
                @UniqueConstraint( columnNames = {"eventDate","eventLocation"})
        }
)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @Column(nullable = false)
    private String eventTitle;

    @Column(nullable = false)
    private LocalDate eventDate;

    @Column(nullable = false)
    private String eventLocation;

    public Event() {
    }

    public Event(int eventId, String eventTitle, LocalDate eventDate, String eventLocation) {
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
