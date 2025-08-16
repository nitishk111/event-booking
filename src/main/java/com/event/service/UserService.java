package com.event.service;

import com.event.model.User;

public interface UserService {

    public String addUser(User user);

    public User findByUserId(int userId);
}
