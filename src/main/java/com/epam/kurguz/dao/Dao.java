package com.epam.kurguz.dao;

import java.sql.SQLException;

/**
 * Created by Евгений on 21.08.2014.
 */
public interface Dao<T> {

    void insert(T entityToCreate) throws DaoException, SQLException;

    T getById(int id) throws DaoException, SQLException;

    void update(T entityToUpdate) throws DaoException, SQLException;

    void delete(T entityToCreate) throws DaoException, SQLException;

    void deleteById(int id) throws SQLException;

}
