package com.event.service.impl;

import com.event.dao.RegistrationDAO;
import com.event.dao.impl.RegistrationDAOImpl;
import com.event.model.Registration;
import com.event.service.RegistrationService;

import java.util.List;

public class RegistrationServiceImpl implements RegistrationService {

    RegistrationDAO registrationDAO;
    public RegistrationServiceImpl(){
        registrationDAO= new RegistrationDAOImpl();
    }
    @Override
    public String registerUser(Registration registration) {
        return registrationDAO.registerUser(registration);
    }

    @Override
    public Registration findRegistrationById(int registrationId) {
        return registrationDAO.findRegistrationById(registrationId);
    }

    @Override
    public List<Registration> getAllRegistration() {
        return registrationDAO.getAllRegistration();
    }

    @Override
    public String markAttendence(int registrationId) {
        return registrationDAO.markAttendence(registrationId);
    }

    @Override
    public String deRegisterForEvent(int registrationId) {
        Registration registration= registrationDAO.findRegistrationById(registrationId);
        return registrationDAO.deRegisterForEvent(registration);
    }
}
