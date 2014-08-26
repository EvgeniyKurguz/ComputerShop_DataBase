package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.DaoException;
import com.epam.kurguz.dao.UserDao;
import com.epam.kurguz.entity.Client;
import com.epam.kurguz.entity.Employee;
import com.epam.kurguz.entity.User;
import com.jolbox.bonecp.BoneCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class H2UserDao extends UserDao {

    private static BoneCP pool;
    H2AbstractDao dao = new H2AbstractDao();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

       @Override
    public User getByUsernameAndPassword(String username, String password) throws DaoException {
        H2ClientDao clientDao = new H2ClientDao() {
            @Override
            public void insert(Object entityToCreate) throws DaoException, SQLException {

            }

            @Override
            public void update(Object entityToUpdate) throws DaoException, SQLException {

            }

            @Override
            public void delete(Object entityToCreate) throws DaoException, SQLException {

            }
        };
        H2EmployeeDao employeeDao = new H2EmployeeDao();
        Client findClient = clientDao.findClientByUsernameAndPassword(username, password);
        Employee findEmployee = employeeDao.findEmployeeByUsernameAndPassword(username, password);
        if (findClient != null) {
            return findClient;
        } else {
            return findEmployee;
        }
    }
}

