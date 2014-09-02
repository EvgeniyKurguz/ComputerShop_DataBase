package com.epam.kurguz.dao;

import com.epam.kurguz.exception.DaoException;

public interface DaoFactory {

    public ClientDao getClientDao() throws DaoException;

    public EmployeeDao getEmployeeDao() throws DaoException;

    public UserDao getUserDao() throws DaoException;
}
