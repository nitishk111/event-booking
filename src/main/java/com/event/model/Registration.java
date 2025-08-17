package com.event.model;

import com.event.util.RegistrationStatus;
import jakarta.persistence.*;

@Entity(name = "Registration")
@Table(name = "registration_details")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private int registrationId;

    @ManyToOne
    private User registeredUser;

    @ManyToOne
    private Event registeredEvent;

    @Column(name = "registration_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private RegistrationStatus registrationStatus = RegistrationStatus.REGISTERED;


    public Registration(){

    }

    public Registration(Event registeredEvent, User registeredUser) {
        this.registeredEvent = registeredEvent;
        this.registeredUser = registeredUser;
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
