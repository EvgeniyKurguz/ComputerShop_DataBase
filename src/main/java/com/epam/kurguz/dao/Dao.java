package com.epam.kurguz.dao;


import com.epam.kurguz.exception.DaoException;

import java.sql.SQLException;

public interface Dao<T> {

    void insert(T entityToCreate) throws DaoException, SQLException;

    T findById(int id) throws DaoException;

    void update(T entityToUpdate) throws DaoException;

    void deleteById(T entityToDelete) throws DaoException;
}
