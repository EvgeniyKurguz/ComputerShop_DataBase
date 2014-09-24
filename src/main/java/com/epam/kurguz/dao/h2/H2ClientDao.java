package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.ClientDao;
import com.epam.kurguz.dao.DaoHelper;
import com.epam.kurguz.dao.JDBCDao;
import com.epam.kurguz.entity.Client;
import com.epam.kurguz.entity.User;
import com.epam.kurguz.exception.DaoException;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2ClientDao extends JDBCDao implements ClientDao {
    private static final String JOIN = "inner join ROLE on client.role_id = ROLE.ID" +
            " inner join CITY on client.city_id = CITY.ID" +
            " inner join COUNTRY on client.country_id = COUNTRY.ID";
    public static final String FIND_BY_ACCOUNT = "SELECT * FROM client " + JOIN + " WHERE client.ACCOUNT=?";
    private static final String FIND_BY_ID = "SELECT * FROM client " + JOIN + " WHERE client.ID=?";
    private static final String FIND_BY_LASTNAME = "SELECT * FROM client " + JOIN + " WHERE LASTNAME=?";
    private static final String FIND_BY_EMAIL = "SELECT * FROM client " + JOIN + " WHERE EMAIL=?";
    private static final String FIND_BY_USERNAME = "SELECT * FROM client " + JOIN + " WHERE USERNAME=?";
    private static final String FIND_CLIENT_BY_USERNAME_AND_PASSWORD = "SELECT * FROM client " + JOIN +
            " WHERE USERNAME = ? and PASSWORD = ?";
    private static final String GET_CLIENT_LIST = "SELECT * FROM client " + JOIN + " WHERE client.is_blocked='FALSE'";
    private static final String FIND_RANGE = "SELECT * FROM CLIENT " + JOIN + " where not is_blocked ORDER BY ID LIMIT ? OFFSET ?";
    private static final String DELETE_BY_ID = "UPDATE client SET is_blocked = 'TRUE' WHERE ID = ?";
    private static final String DELETE_BY_EMAIL = "DELETE FROM client WHERE EMAIL=?";
    private static final String DELETE_BY_LASTNAME = "DELETE FROM client WHERE LASTNAME=?";
    private static final String UPDATE = "UPDATE  client" +
            " SET FIRSTNAME = ?, LASTNAME = ?, BIRTH = ?, PHONE = ?," +
            " ATTESTATION_NUMBER= ?, EMAIL= ?, USERNAME=?, PASSWORD=?, " +
            "role_id=(select id from ROLE where ROLE = ?)," +
            "city_id=(select id from CITY where CITY = ?), " +
            "country_id=(select id from COUNTRY where COUNTRY = ?),ACCOUNT=? WHERE ID = ?";
    private static final String UPDATE_ACCOUNT = "UPDATE  client SET ACCOUNT=? WHERE ID=?";
    private static final String CREATE_CLIENT = "INSERT INTO client VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?," +
            " (select id from role where role = ?), ?,?,0,false)";
    private static final String ID = "id";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String BIRTH = "birth";
    private static final String PHONE = "phone";
    private static final String ATTESTATION_NUMBER = "attestation_number";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String ROLE = "role";
    private static final String EMAIL = "email";
    private static final String CITY = "city";
    private static final String COUNTRY = "country";
    private static final String ACCOUNT = "account";
    private static final String IS_BLOCKED = "is_blocked";

    public H2ClientDao(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public void update(Client client) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, String.valueOf(client.getBirth()));
            preparedStatement.setString(4, client.getPhone());
            preparedStatement.setString(5, client.getAttestationNumber());
            preparedStatement.setString(6, client.getEmail());
            preparedStatement.setString(7, client.getUsername());
            preparedStatement.setString(8, client.getPassword());
            preparedStatement.setString(9, String.valueOf(client.getRole()));
            preparedStatement.setString(10, client.getCity());
            preparedStatement.setString(11, client.getCountry());
            preparedStatement.setBigDecimal(12, client.getAccount());
            preparedStatement.setInt(13, client.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateAccount(Client client) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT)) {
            preparedStatement.setBigDecimal(1, client.getAccount());
            preparedStatement.setInt(2, client.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void insert(Client client) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CLIENT)) {
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, String.valueOf(client.getBirth()));
            preparedStatement.setString(4, client.getPhone());
            preparedStatement.setString(5, client.getAttestationNumber());
            preparedStatement.setString(6, client.getEmail());
            preparedStatement.setString(7, client.getUsername());
            preparedStatement.setString(8, client.getPassword());
            preparedStatement.setString(9, String.valueOf(client.getRole()));
            preparedStatement.setString(10, client.getCity());
            preparedStatement.setString(11, client.getCountry());
//            preparedStatement.setBoolean(12, client.isBlocked());
//            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//            int anInt = generatedKeys.getInt(1);
//            preparedStatement.setInt(anInt, client.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Client findById(int id) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            return getClientFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public Client findByAccount(BigDecimal account) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ACCOUNT)) {
            preparedStatement.setBigDecimal(1, account);
            resultSet = preparedStatement.executeQuery();
            return getClientFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public Client findByLastName(String lastName) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_LASTNAME)) {
            preparedStatement.setString(1, lastName);
            resultSet = preparedStatement.executeQuery();
            return getClientFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public Client findByEmail(String email) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            return getClientFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public Client findByUsername(String username) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            return getClientFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public void deleteById(Client client) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setInt(1, client.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteByEmail(Client client) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_EMAIL)) {
            preparedStatement.setString(1, client.getEmail());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteByLastName(Client client) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_LASTNAME)) {
            preparedStatement.setString(1, client.getLastName());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Client> getClientList() throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CLIENT_LIST)) {
            List<Client> clients = new ArrayList<>();
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clients.add(createClient(resultSet));
            }
            return clients;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public Client findClientByUsernameAndPassword(String username, String password) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_CLIENT_BY_USERNAME_AND_PASSWORD)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            return getClientFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public boolean clientLoginIsOccupied(String username) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public List<Client> findRange(int limit, int offset) throws DaoException {
        ResultSet resultSet = null;
        List<Client> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_RANGE)) {
            preparedStatement.setInt(1, offset);
            preparedStatement.setInt(2, limit);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(createClient(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
        return result;
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
                client.setAttestationNumber(resultSet.getString(ATTESTATION_NUMBER));
                client.setUsername(resultSet.getString(USERNAME));
                client.setPassword(resultSet.getString(PASSWORD));
                client.setEmail(resultSet.getString(EMAIL));
                client.setRole(User.Role.valueOf(resultSet.getString(ROLE)));
                client.setCity(resultSet.getString(CITY));
                client.setAccount(resultSet.getBigDecimal(ACCOUNT));
                client.setCountry(resultSet.getString(COUNTRY));
                client.setBlocked(resultSet.getBoolean(IS_BLOCKED));
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
            String attestationNumber = resultSet.getString(ATTESTATION_NUMBER);
            String username = resultSet.getString(USERNAME);
            String password = resultSet.getString(PASSWORD);
            String email = resultSet.getString(EMAIL);
            User.Role role = User.Role.valueOf(resultSet.getString(ROLE));
            BigDecimal account = resultSet.getBigDecimal(ACCOUNT);
            String city = resultSet.getString(CITY);
            String country = resultSet.getString(COUNTRY);
            String blocked = resultSet.getString(IS_BLOCKED);
            return new Client.Builder()
                    .id(id)
                    .firstName(firstName)
                    .lastName(lastName)
                    .birth(Date.valueOf(birth))
                    .phone(phone)
                    .attestationNumber(attestationNumber)
                    .username(username)
                    .password(password)
                    .email(email)
                    .role(role)
                    .account(account)
                    .city(city)
                    .country(country)
                    .blocked(Boolean.valueOf(blocked))
                    .build();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}