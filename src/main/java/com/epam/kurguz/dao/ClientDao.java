package com.epam.kurguz.dao;

import com.epam.kurguz.entity.Client;

import java.util.List;

public interface ClientDao<T> extends Dao<Client> {

    void insert(Client client) throws DaoException;

    void update(Client client) throws DaoException;

    Client getByLastName(String lastName) throws DaoException;

    Client getByEmail(String email) throws DaoException;

    Client getByUsername(String username) throws DaoException;

    Client findClientByUsernameAndPassword(String username, String password) throws DaoException;

    void deleteByEmail(String email) throws DaoException;

    void deleteByLastName(String lastName) throws DaoException;

    List<Client> getClientList() throws DaoException;
}
