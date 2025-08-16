package com.event.Servlets;


import com.event.dao.impl.UserDAOImpl;
import com.event.model.User;
import com.event.service.UserService;
import com.event.service.impl.UserServiceImpl;
import com.event.util.HibernateUtil;
import org.hibernate.Session;


public class Main {
    public static void main(String[] args) {

        User user=new User("Divyansh", "divyansh@info.com", "meranamehai");

        UserService userService= new UserServiceImpl();

        //System.out.println(userService.addUser(user));
        System.out.println(userService.findByUserId(1));
    }
}
