package com.event.dao;

import com.event.model.Event;
import com.event.model.Registration;
import com.event.model.User;

import java.util.List;

public interface RegistrationDAO {

    public String registerUser(User user, Event event);

    public Registration findRegistrationById(int registrationId);
    public List<Registration> getAllRegistration();

    public String markAttendence(int registrationId);
    public String deRegisterForEvent(int registrationId);
}
