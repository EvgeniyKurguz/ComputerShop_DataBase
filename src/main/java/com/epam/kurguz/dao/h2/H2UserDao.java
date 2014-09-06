package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.UserDao;
import com.epam.kurguz.entity.User;
import com.epam.kurguz.exception.DaoException;
import com.jolbox.bonecp.BoneCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class H2UserDao  extends UserDao {

    private static BoneCP pool;
    H2AbstractDao dao = new H2AbstractDao();
    Connection connection;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public H2UserDao(Connection connection) {
        this.connection = connection;
    }


    public User findUserByUsernameAndPassword(String username, String password) throws DaoException {
//        try {
//            H2ClientDao clientDao = new H2ClientDao(connection) {
//            };
//            H2EmployeeDao employeeDao = new H2EmployeeDao(connection);
//            Client findClient = clientDao.findClientByUsernameAndPassword(username, password);
//            Employee findEmployee = employeeDao.findEmployeeByUsernameAndPassword(username, password);
//            if (findClient != null) {
//                return findClient;
//            } else return findEmployee;
//        } finally {
//            dao.closing(resultSet, preparedStatement, connection);
        return null;
    }


    @Override
    public User getByUsernameAndPassword(String username, String password) throws DaoException {
        return null;
    }
}

