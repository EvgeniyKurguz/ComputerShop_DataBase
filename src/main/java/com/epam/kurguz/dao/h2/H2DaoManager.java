package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.*;
import com.epam.kurguz.exception.DaoException;

import java.sql.Connection;
import java.sql.SQLException;

public class H2DaoManager implements DaoManager {

    private Connection connection;

    public H2DaoManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    public ClientDao getClientDao() {
        return new H2ClientDao(connection);
    }

    public EmployeeDao getEmployeeDao() {
        return new H2EmployeeDao(connection);
    }

    public ProductDao getProductDao() {
        return new H2ProductDao(connection);
    }

    public OrderDao getBookingDao() {
        return new H2OrderDao (connection);
    }

    @Override
    public UserDao getUserDao() {
        return new H2UserDao(connection);
    }

    @Override
    public void openTransaction() throws DaoException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void closeTransaction() throws DaoException {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void commit() throws DaoException {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void rollBack() throws DaoException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void close() throws DaoException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
