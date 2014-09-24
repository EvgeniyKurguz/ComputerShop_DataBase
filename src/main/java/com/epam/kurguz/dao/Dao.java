package com.epam.kurguz.dao;


import com.epam.kurguz.exception.DaoException;

public interface Dao<T> {

    void insert(T entityToCreate) throws DaoException;

    T findById(int id) throws DaoException;

    void update(T entityToUpdate) throws DaoException;

    void deleteById(T entityToDelete) throws DaoException;
}
