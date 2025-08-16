package com.event.model;

import com.event.util.RegistrationStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "registration_details")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registrationId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User registeredUser;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "eventId")
    private Event registeredEvent;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RegistrationStatus registrationStatus;


    public Registration(){

    }

    public Registration(int registrationId, Event registeredEvent, User registeredUser, RegistrationStatus registrationEvent) {
        this.registrationId = registrationId;
        this.registeredEvent = registeredEvent;
        this.registeredUser = registeredUser;
        this.registrationStatus = registrationEvent;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public User getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(User registeredUser) {
        this.registeredUser = registeredUser;
    }

    public Event getRegisteredEvent() {
        return registeredEvent;
    }

    public void setRegisteredEvent(Event registeredEvent) {
        this.registeredEvent = registeredEvent;
    }

    public RegistrationStatus getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(RegistrationStatus registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "registrationId=" + registrationId +
                ", registeredUser=" + registeredUser +
                ", registeredEvent=" + registeredEvent +
                ", registrationStatus='" + registrationStatus + '\'' +
                '}';
    }
}
