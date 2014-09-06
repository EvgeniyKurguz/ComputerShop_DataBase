package com.epam.kurguz.dao;

import com.epam.kurguz.exception.DaoException;

import java.sql.Connection;

public interface DaoFactory {

    public Connection getConnection() throws DaoException;

    public DaoManager getDaoManager() throws DaoException;
}

