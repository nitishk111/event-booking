package com.event.service;

import com.event.model.Registration;

import java.util.List;

public interface RegistrationService {
    public String registerUser(Registration registration);

    public Registration findRegistrationById(int registrationId);
    public List<Registration> getAllRegistration();

    public String markAttendence(int registrationId);


    public String deRegisterForEvent(int registrationId);
}
