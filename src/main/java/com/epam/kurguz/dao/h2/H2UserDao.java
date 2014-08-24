package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.DaoException;
import com.epam.kurguz.dao.UserDao;
import com.epam.kurguz.entity.User;
import com.jolbox.bonecp.BoneCP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class H2UserDao extends UserDao {

    private static final String GET_BY_USERNAME_AND_PASSWORD = "SELECT * FROM CLIENTS WHERE USERNAME=? AND PASSWORD=?";
    private static final String GET_BY_USERNAME = "SELECT USERNAME FROM CLIENTS WHERE USERNAME=?";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static BoneCP pool;
    private static Logger logger = LoggerFactory.getLogger(H2UserDao.class);
    H2AbstractDao dao = new H2AbstractDao();

    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;

    @Override
    public User getByUsernameAndPassword(String username, String password) throws DaoException {
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(GET_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            return getUsernameAndPasswordFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closing(resultSet, preparedStatement, connection);
        }
    }

    public boolean loginIsOccupied(String username) throws DaoException {//проверить с БД
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(GET_BY_USERNAME);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closing(resultSet, preparedStatement, connection);
        }
    }

    private User getUsernameAndPasswordFromResultSet(ResultSet resultSet) throws DaoException {
        User user = new User();
        try {
            resultSet.next();
            user.setUserName(resultSet.getString(USERNAME));
            user.setPassword(resultSet.getString(PASSWORD));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }

//    @Override
//    public void insert(User entityToCreate) throws DaoException {
//
//    }
//
//    @Override
//    public User getById(int id) throws DaoException {
//        return null;
//    }
//
//    @Override
//    public void update(User entityToUpdate) throws DaoException {
//
//    }
//
//    @Override
//    public void deleteById(int id) throws DaoException {
//
//    }
}

