package com.epam.kurguz.dao;

import com.epam.kurguz.entity.BaseEntity;
import com.epam.kurguz.entity.PaginatedList;
import com.epam.kurguz.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JDBCDao<T extends BaseEntity>  {
    public Connection connection;

    public JDBCDao(Connection connection) {
        this.connection = connection;
    }

    public abstract String getSelectRequest() throws DaoException;

    public abstract String getSelectCount() throws DaoException;

    public abstract String getSelectRequestByRange() throws DaoException;

    public abstract T getFromResultSet(ResultSet resultSet) throws DaoException;

    public abstract T createEntity(ResultSet resultSet) throws DaoException;

    public List<T> findAll() throws DaoException {
        ResultSet resultSet = null;
        List<T> result = new ArrayList<>();
        String sql = getSelectRequest();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
        return result;
    }


    public PaginatedList<T> findRange(int pageNumber, int rowsCount) throws DaoException {
        ResultSet resultSet = null;
        PaginatedList<T> result = new PaginatedList<>();
        String findRange = getSelectRequestByRange();
        try (PreparedStatement preparedStatement = connection.prepareStatement(findRange)) {
            preparedStatement.setInt(1, rowsCount);
            preparedStatement.setInt(2, ((pageNumber-1)*rowsCount));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
        return result;
    }

    public int getCount() {
        int result = 0;
        String count = "count(*)";
        ResultSet resultSet = null;
        String sql = getSelectCount();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                result = resultSet.getInt(count);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
        return result;
    }
}
