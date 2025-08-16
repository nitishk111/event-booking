package com.event.service.impl;

import com.event.dao.UserDAO;
import com.event.dao.impl.UserDAOImpl;
import com.event.model.User;
import com.event.service.UserService;

public class UserServiceImpl implements UserService {

    UserDAO userDAO;
    public UserServiceImpl(){
        userDAO = new UserDAOImpl();
    }
    @Override
    public String addUser(User user) {
        return userDAO.addUser(user);
    }

    @Override
    public User findByUserId(int userId) {
        return userDAO.findUserById(userId);
    }
}
