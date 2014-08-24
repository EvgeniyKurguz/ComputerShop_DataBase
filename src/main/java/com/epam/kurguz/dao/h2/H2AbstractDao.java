package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class H2AbstractDao {

    public void closing(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) throws DaoException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void closingPreparedStatAndConn(PreparedStatement preparedStatement, Connection connection) throws DaoException {
        try {

            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
