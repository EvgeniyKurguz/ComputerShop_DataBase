package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.*;
import com.epam.kurguz.entity.Client;
import com.epam.kurguz.entity.Employee;
import com.epam.kurguz.entity.PaginatedList;
import com.epam.kurguz.entity.User;
import com.epam.kurguz.exception.DaoException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class H2UserDao extends JDBCDao<User> implements UserDao {

    public H2UserDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectRequest() throws DaoException {
        return null;
    }

    @Override
    public String getSelectCount() throws DaoException {
        return null;
    }

    @Override
    public String getSelectRequestByRange() throws DaoException {
        return null;
    }

    @Override
    public User getFromResultSet(ResultSet resultSet) throws DaoException {
        return null;
    }

    @Override
    public User createEntity(ResultSet resultSet) throws DaoException {
        return null;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) throws DaoException {
        ResultSet resultSet = null;
        DaoFactory factory = new H2DaoFactory();
        DaoManager daoManager = factory.getDaoManager();
        ClientDao clientDao = daoManager.getClientDao();
        EmployeeDao employeeDao = daoManager.getEmployeeDao();
        Client findClient = clientDao.findClientByUsernameAndPassword(username, password);
        Employee findEmployee = employeeDao.findEmployeeByUsernameAndPassword(username, password);
        if (findClient != null) {
            return findClient;
        } else return findEmployee;
    }

    @Override
    public void insert(User entityToCreate) throws DaoException {

    }

    @Override
    public User findById(int id) throws DaoException {
        return null;
    }

    @Override
    public void update(User entityToUpdate) throws DaoException {

    }

    @Override
    public void deleteById(User entityToDelete) throws DaoException {

    }
}
