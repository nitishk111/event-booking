package com.event.Servlets;


import com.event.dao.impl.UserDAOImpl;
import com.event.model.Event;
import com.event.model.Feedback;
import com.event.model.Registration;
import com.event.model.User;
import com.event.service.EventService;
import com.event.service.RegistrationService;
import com.event.service.UserService;
import com.event.service.impl.EventServiceImpl;
import com.event.service.impl.RegistrationServiceImpl;
import com.event.service.impl.UserServiceImpl;
import com.event.util.FeedbackRating;
import com.event.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        User user=new User("Rohit", "rsq@info.com", "qwertrw22");
        UserService userService= new UserServiceImpl();

        EventService eventService= new EventServiceImpl();

        Event event= new Event("Bass Kar Bassi", LocalDate.of(2026,1,18),"Kanpur");
//        eventService.addEvent(event);
//        System.out.println(eventService.fingEventById(3));

      //  userService.addUser(user);
//        eventService.addEvent(event);

        RegistrationService registrationService= new RegistrationServiceImpl();
        Registration registration = new Registration(eventService.fingEventById(1),userService.findUserById(3));
        System.out.println(registrationService.registerUser(registration));






//        Feedback feedback= new Feedback(registration, FeedbackRating.FOUR, "Show is fine");
//        Session session= HibernateUtil.getSession();
//        Transaction tx = session.beginTransaction();
//
//        session.persist(user);
//        session.persist(event);
//        session.persist(registration);
//        session.persist(feedback);
//
//        tx.commit();
//
//        session.close();



    }
}
