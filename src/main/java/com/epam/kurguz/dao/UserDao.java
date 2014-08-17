package com.epam.kurguz.dao;


import com.epam.kurguz.dao.h2.H2UserDao;
import com.epam.kurguz.entity.User;

public class UserDao implements H2UserDao {

    public User findByCredentials(String username, String password) {
        if (!"I_am".equals(username) || !"1".equals(password)) return null;
        User user = new User();
        user.setUserName("I_am");
        user.setPassword("1");
        return user;
    }
}


