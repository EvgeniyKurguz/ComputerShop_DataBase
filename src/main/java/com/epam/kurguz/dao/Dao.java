package com.epam.kurguz.dao;


import com.epam.kurguz.entity.PaginatedList;
import com.epam.kurguz.exception.DaoException;

import java.util.List;

public interface Dao<T> {

    void insert(T entityToCreate) throws DaoException;

    T findById(int id) throws DaoException;

    void update(T entityToUpdate) throws DaoException;

    void deleteById(T entityToDelete) throws DaoException;

    List<T> findAll() throws DaoException;

    PaginatedList<T> findRange(int pageNumber, int rowsCount) throws DaoException;

    int getCount() throws DaoException;
}