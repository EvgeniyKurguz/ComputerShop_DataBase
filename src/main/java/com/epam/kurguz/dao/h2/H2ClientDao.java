package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.ClientDao;
import com.epam.kurguz.exception.DaoException;
import com.epam.kurguz.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2ClientDao implements ClientDao {
    private static final String JOIN = " inner join CITY on CLIENTS.ID_CITY = CITY.ID" +
            " inner join COUNTRY on CLIENTS.ID_COUNTRY = COUNTRY.ID";
    private static final String FIND_BY_ID = "SELECT * FROM CLIENTS " + JOIN + " WHERE CLIENTS.ID=?";
    private static final String FIND_BY_LASTNAME = "SELECT * FROM CLIENTS " + JOIN + " WHERE LASTNAME=?";
    private static final String FIND_BY_EMAIL = "SELECT * FROM CLIENTS " + JOIN + " WHERE EMAIL=?";
    private static final String FIND_BY_USERNAME = "SELECT * FROM CLIENTS " + JOIN + " WHERE USERNAME=?";
    private static final String FIND_CLIENT_BY_USERNAME_AND_PASSWORD = "SELECT * FROM CLIENTS " + JOIN +
            " WHERE USERNAME = ? and PASSWORD = ?";
    private static final String DELETE_BY_ID = "DELETE FROM CLIENTS WHERE ID = ?";
    private static final String DELETE_BY_EMAIL = "DELETE FROM CLIENTS WHERE EMAIL=?";
    private static final String DELETE_BY_LASTNAME = "DELETE FROM CLIENTS WHERE LASTNAME=?";
    private static final String UPDATE = "UPDATE  CLIENTS" +
            " SET FIRSTNAME = ?, LASTNAME = ?, BIRTH = ?, PHONE = ?," +
            " ATTESTATION_NUMBER= ?, EMAIL= ?, USERNAME=?, PASSWORD=?, " +
            "ID_CITY=(select id from CITY where CITY = ?), " +
            "ID_COUNTRY=(select id from COUNTRY where COUNTRY = ?) WHERE ID = ?";
    private static final String CREATE_CLIENT = "INSERT INTO  CLIENTS VALUES (default , ?, ?, ?, ?, ?, ?, ?, ?," +
            " (select id from role where role = ?)," +
            " ?," +
            " ?)";
    private static final String GET_CLIENT_LIST = "SELECT * FROM CLIENTS" + JOIN;
    private static final String ID = "id";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String BIRTH = "birth";
    private static final String PHONE = "phone";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";
    private static final String CITY = "city";
    private static final String COUNTRY = "country";
    H2AbstractDao dao = new H2AbstractDao();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private Connection connection;

    public H2ClientDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void update(Client client) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, String.valueOf(client.getBirth()));
            preparedStatement.setString(4, client.getPhone());
            preparedStatement.setString(5, client.getEmail());
            preparedStatement.setString(6, client.getUserName());
            preparedStatement.setString(7, client.getPassword());
            preparedStatement.setString(8, client.getCity());
            preparedStatement.setString(9, client.getCountry());
            preparedStatement.setInt(10, client.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public void insert(Client client) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(CREATE_CLIENT);
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, String.valueOf(client.getBirth()));
            preparedStatement.setString(4, client.getPhone());
            preparedStatement.setString(6, client.getEmail());
            preparedStatement.setString(7, client.getUserName());
            preparedStatement.setString(8, client.getPassword());
            preparedStatement.setString(9, client.getCity());
            preparedStatement.setString(10, client.getCountry());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public Client findById(int id) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            return getClientFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Client findByLastName(String lastName) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(FIND_BY_LASTNAME);
            preparedStatement.setString(1, lastName);
            resultSet = preparedStatement.executeQuery();
            return getClientFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closing(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public Client findByEmail(String email) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(FIND_BY_EMAIL);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            return getClientFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closing(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public Client findByUsername(String username) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(FIND_BY_USERNAME);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            return getClientFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closing(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public void deleteById(Client client) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, client.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public void deleteByEmail(Client client) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_EMAIL);
            preparedStatement.setString(1, client.getEmail());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public void deleteByLastName(Client client) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_LASTNAME);
            preparedStatement.setString(1, client.getLastName());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public List<Client> getClientList() throws DaoException {
        try {
            List<Client> clients = new ArrayList<Client>();
            preparedStatement = connection.prepareStatement(GET_CLIENT_LIST);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clients.add(createClient(resultSet));
            }
            return clients;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closing(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public Client findClientByUsernameAndPassword(String username, String password) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(FIND_CLIENT_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            return getClientFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean clientLoginIsOccupied(String username) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(FIND_BY_USERNAME);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Client getClientFromResultSet(ResultSet resultSet) throws DaoException {
        Client client = null;
        try {
            if (resultSet.next()) {
                client = new Client();
                client.setId(resultSet.getInt(ID));
                client.setFirstName(resultSet.getString(FIRST_NAME));
                client.setLastName(resultSet.getString(LAST_NAME));
                client.setBirth(Date.valueOf(resultSet.getString(BIRTH)));
                client.setPhone(resultSet.getString(PHONE));
                client.setUserName(resultSet.getString(USERNAME));
                client.setPassword(resultSet.getString(PASSWORD));
                client.setEmail(resultSet.getString(EMAIL));
                client.setCity(resultSet.getString(CITY));
                client.setCountry(resultSet.getString(COUNTRY));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return client;
    }

    private Client createClient(ResultSet resultSet) throws DaoException {
        try {
            int id = resultSet.getInt(ID);
            String firstName = resultSet.getString(FIRST_NAME);
            String lastName = resultSet.getString(LAST_NAME);
            String birth = resultSet.getString(BIRTH);
            String phone = resultSet.getString(PHONE);
            String username = resultSet.getString(USERNAME);
            String password = resultSet.getString(PASSWORD);
            String email = resultSet.getString(EMAIL);
            String city = resultSet.getString(CITY);
            String country = resultSet.getString(COUNTRY);
            return new Client.Builder()
                    .id(id)
                    .firstName(firstName)
                    .lastName(lastName)
                    .birth(Date.valueOf(birth))
                    .phone(phone)
                    .username(username)
                    .password(password)
                    .email(email)
                    .city(city)
                    .country(country)
                    .build();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}