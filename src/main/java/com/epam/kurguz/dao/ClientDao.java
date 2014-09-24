package com.epam.kurguz.dao;

import com.epam.kurguz.entity.Client;
import com.epam.kurguz.exception.DaoException;

import java.math.BigDecimal;
import java.util.List;

public interface ClientDao extends Dao<Client> {

    Client findByLastName(String lastName) throws DaoException;

    Client findByEmail(String email) throws DaoException;

    Client findByUsername(String username) throws DaoException;

    Client findClientByUsernameAndPassword(String username, String password) throws DaoException;

    void deleteByEmail(Client client) throws DaoException;

    void deleteByLastName(Client client) throws DaoException;

    List<Client> getClientList() throws DaoException;

    boolean clientLoginIsOccupied(String username) throws DaoException;

    List<Client> findRange(int position, int count) throws DaoException;

    void updateAccount(Client client) throws DaoException;

    Client findByAccount(BigDecimal account) throws DaoException;

}
