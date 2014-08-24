package com.epam.kurguz.dao;

import com.epam.kurguz.entity.Client;

import java.util.List;

public interface ClientDao<T> extends Dao<Client> {

    T getByLastName(String lastName) throws DaoException;

    T getByEmail(String email) throws DaoException;

    T getByUsername(String username) throws DaoException;

    T getByUsernameAndPassword(String username, String password) throws DaoException;

    void deleteByEmail(String email) throws DaoException;

    void deleteByLastName(String lastName) throws DaoException;

    List<T> getClientList() throws DaoException;
}
