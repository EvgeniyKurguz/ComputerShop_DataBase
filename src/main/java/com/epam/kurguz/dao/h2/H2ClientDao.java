package com.epam.kurguz.dao.h2;


import com.epam.kurguz.dao.ClientDao;
import com.epam.kurguz.dao.DaoException;
import com.epam.kurguz.entity.Client;
import com.epam.kurguz.pool.PoolException;
import com.jolbox.bonecp.BoneCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class H2ClientDao implements ClientDao {

    private static final String CREATE_CLIENT = "INSERT INTO  CLIENTS VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_CLIENT = "DELETE FROM CLIENTS WHERE ID= ?";
    private static final String FIND_BY_ID = "SELECT * FROM CLIENTS WHERE ID=?";
    private static final String FIND_BY_LASTNAME = "SELECT * FROM CLIENTS WHERE LASTNAME=?";
    private static final String FIND_BY_EMAIL = "SELECT * FROM CLIENTS WHERE EMAIL=?";
    private static final String DELETE_BY_ID = "DELETE FROM CLIENTS WHERE ID=?";
    private static final String DELETE_BY_EMAIL = "DELETE FROM CLIENTS WHERE EMAIL=?";
    private static final String DELETE_BY_LASTNAME = "DELETE FROM CLIENTS WHERE LASTNAME=?";
    private static final String UPDATE = "UPDATE  CLIENTS" +
            " SET FIRSTNAME = ?, LASTNAME = ?, BIRTH = ?, PHONE = ?,  EMAIL= ? WHERE ID = ?";
    private static final String GET_CLIENT_LIST = "SELECT * FROM CLIENTS";
    private static final String GET_BY_USERNAME = "SELECT * FROM CLIENTS WHERE USERNAME=?";
    private static final BoneCP pool;
    H2AbstractDao dao = new H2AbstractDao();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private static final String ID = "id";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String BIRTH = "birth";
    private static final String PHONE = "phone";

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String ROLE = "role";
    private static final String EMAIL = "email";

    static {
        BoneCP tmp = null;
        try {
            tmp = H2DaoFactory.getH2ConnectionPool();
        } catch (PoolException e) {
            //add
        }
        pool = tmp;
    }

    @Override
    public void insert(Client client) throws DaoException {
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_CLIENT);
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getBirth());
            preparedStatement.setString(4, client.getPhone());

            preparedStatement.setString(6, client.getEmail());
            preparedStatement.setInt(7, client.getId());
            preparedStatement.setString(8, client.getUserName());
            preparedStatement.setString(9, client.getPassword());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public void update(Client client) throws DaoException {
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, client.getId());
            preparedStatement.setString(3, client.getLastName());
            preparedStatement.setString(4, client.getBirth());
            preparedStatement.setString(5, client.getPhone());

            preparedStatement.setString(6, client.getEmail());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public Client getById(int id) throws DaoException {
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            return getClientFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closing(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public Client getByLastName(String lastName) throws DaoException {
        try {
            connection = pool.getConnection();
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
    public Client getByEmail(String email) throws DaoException {
        try {
            connection = pool.getConnection();
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
    public Client getByUsername(String username) throws DaoException {
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(GET_BY_USERNAME);
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
    public void deleteById(int id) throws DaoException {
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public void deleteByEmail(String email) throws DaoException {
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_BY_EMAIL);
            preparedStatement.setString(1, email);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public void deleteByLastName(String lastName) throws DaoException {
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_BY_LASTNAME);
            preparedStatement.setString(1, lastName);
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
            List<Client> clients = new ArrayList<>();
            connection = pool.getConnection();
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
            return new Client.Builder()
                    .id(id)
                    .firstName(firstName)
                    .lastName(lastName)
                    .birth(birth)
                    .phone(phone)
                    .username(username)
                    .password(password)
                    .email(email)
                    .build();
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
                client.setBirth(resultSet.getString(BIRTH));
                client.setPhone(resultSet.getString(PHONE));
                client.setUserName(resultSet.getString(USERNAME));
                client.setPassword(resultSet.getString(PASSWORD));

            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return client;
    }

    @Override
    public Client findClientByUsernameAndPassword(String username, String password) throws DaoException {

        String sql = "SELECT *" +
                "FROM CLIENTS " +
                "where USERNAME = " + "'" + username + "'" + "and PASSWORD = " + "'" + password + "'";
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            return getClientFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closing(resultSet, preparedStatement, connection);
        }
    }

    public boolean loginIsOccupied(String username) throws DaoException {
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(GET_BY_USERNAME);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closing(resultSet, preparedStatement, connection);
        }
    }
}
