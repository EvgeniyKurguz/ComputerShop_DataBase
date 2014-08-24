package com.epam.kurguz.dao.h2;


import com.epam.kurguz.dao.ClientDao;
import com.epam.kurguz.dao.DaoException;
import com.epam.kurguz.entity.Client;

import java.sql.SQLException;
import java.util.List;

public class H2ClientDao implements ClientDao<Client> {

    private static final String CREATE_CLIENT = "INSERT INTO  CLIENTS VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_CLIENT = "DELETE FROM CLIENTS WHERE ID= ?";
    private static final String FIND_BY_ID = "SELECT * FROM CLIENTS WHERE ID=?";
    private static final String FIND_BY_LASTNAME = "SELECT * FROM CLIENTS WHERE LASTNAME=?";
    private static final String FIND_BY_EMAIL = "SELECT * FROM CLIENTS WHERE EMAIL=?";
    private static final String DELETE_BY_ID = "DELETE FROM CLIENTS WHERE ID=?";
    private static final String DELETE_BY_EMAIL = "DELETE FROM CLIENTS WHERE EMAIL=?";
    private static final String DELETE_BY_LASTNAME = "DELETE FROM CLIENTS WHERE LASTNAME=?";
    private static final String UPDATE = "UPDATE  CLIENTS" +
            " SET FIRSTNAME = ?, LASTNAME = ?, BIRTH = ?, PHONE = ?, ATTESTATION_NUMBER= ?, EMAIL= ? WHERE ID = ?";
    private static final String GET_CLIENT_LIST = "SELECT * FROM CLIENTS";
    private static final String GET_BY_USERNAME = "SELECT * FROM CLIENTS WHERE USERNAME=?";
    private static final String GET_BY_USERNAME_AND_PASSWORD = "SELECT * FROM CLIENTS WHERE USERNAME=? AND PASSWORD=?";
//    private static final BoneCP pool;
    private static final String ID = "id";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String BIRTH = "birth";
    private static final String PHONE = "phone";
    private static final String ATTESTATION_NUMBER = "attestation_Number";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String ROLE = "role";
    private static final String EMAIL = "email";

    @Override
    public Client getByLastName(String lastName) throws DaoException {
        return null;
    }

    @Override
    public Client getByEmail(String email) throws DaoException {
        return null;
    }

    @Override
    public Client getByUsername(String username) throws DaoException {
        return null;
    }

    @Override
    public Client getByUsernameAndPassword(String username, String password) throws DaoException {
        return null;
    }

    @Override
    public void deleteByEmail(String email) throws DaoException {

    }

    @Override
    public void deleteByLastName(String lastName) throws DaoException {

    }

    @Override
    public List<Client> getClientList() throws DaoException {
        return null;
    }

    @Override
    public void insert(Client entityToCreate) throws DaoException, SQLException {

    }

    @Override
    public Client getById(int id) throws DaoException, SQLException {
        return null;
    }

    @Override
    public void update(Client entityToUpdate) throws DaoException, SQLException {

    }

    @Override
    public void delete(Client entityToCreate) throws DaoException, SQLException {

    }

    @Override
    public void deleteById(int id) throws SQLException {

    }

//
}
