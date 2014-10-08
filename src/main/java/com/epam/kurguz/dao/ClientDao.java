package com.epam.kurguz.dao;

import com.epam.kurguz.entity.Client;
import com.epam.kurguz.exception.DaoException;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface ClientDao extends Dao<Client> {

    List<Client> findByLastName(String lastName) throws DaoException;

    List<Client> findByFirstName(String firstName) throws DaoException;

    Client findByEmail(String email) throws DaoException;

    Client findByUsername(String username) throws DaoException;

    Client findClientByUsernameAndPassword(String username, String password) throws DaoException;

    void deleteByEmail(Client client) throws DaoException;

    void deleteByLastName(Client client) throws DaoException;

    List<Client> getClientList() throws DaoException;

    boolean clientLoginIsOccupied(String username) throws DaoException;

    void updateAccount(Client client) throws DaoException;

    Client findByAccount(BigDecimal account) throws DaoException;

    List<Client> findByBirth(Date birth) throws DaoException;

    Client findByPhone(String phone) throws DaoException;

    Client findByAttestationNumber(int attestationNumber) throws DaoException;

    List<Client> findByCity(String city) throws DaoException;

    List<Client> findByCountry(String country) throws DaoException;
}
