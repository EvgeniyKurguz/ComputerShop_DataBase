package com.epam.kurguz.dao;


import com.epam.kurguz.exception.DaoException;

import java.sql.Connection;

public interface DaoManager {

    Connection getConnection() throws DaoException;

    ClientDao getClientDao() throws DaoException;

    EmployeeDao getEmployeeDao() throws DaoException;

    ProductDao getProductDao() throws DaoException;

    OrderDao getBookingDao() throws DaoException;

    UserDao getUserDao() throws DaoException;

    public void openTransaction() throws DaoException;

    public void closeTransaction() throws DaoException;

    public void commit() throws DaoException;

    public void rollBack() throws DaoException;

    public void close() throws DaoException;
}
