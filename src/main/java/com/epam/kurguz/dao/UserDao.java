package com.epam.kurguz.dao;


import com.epam.kurguz.entity.User;
import com.epam.kurguz.exception.DaoException;

public interface UserDao extends Dao<User> {

    User findUserByUsernameAndPassword(String username, String password) throws DaoException;
}


