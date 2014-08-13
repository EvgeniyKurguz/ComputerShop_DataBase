package com.epam.kurguz.dao;

import com.epam.kurguz.dao.AbstractJDBCDao;
import com.epam.kurguz.dao.h2.H2ClientDao;
import com.epam.kurguz.entity.Client;
import com.epam.kurguz.exception.PersistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public  class ClientDao extends AbstractJDBCDao<Client, Integer> implements H2ClientDao{

    public ClientDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT ID, FIRSTNAME, LASTNAME, BIRTH, PHONE, ATTESTATION_NUMBER, EMAIL FROM CLIENTS";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO  CLIENTS(FIRSTNAME, LASTNAME, BIRTH, PHONE, ATTESTATION_NUMBER, EMAIL) \n" +
                "VALUES (?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE  CLIENTS \n" +
                "SET FIRSTNAME = ?, LASTNAME = ?, BIRTH = ?, PHONE = ?, ATTESTATION_NUMBER= ?, EMAIL= ? \n" +
                "WHERE ID = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM CLIENTS WHERE ID= ?;";
    }

    @Override
    protected List<Client> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Client> result = new LinkedList<Client>();
        try {
            while (rs.next()) {
                PersistClient client = new PersistClient();
                client.setId(rs.getInt("ID"));
                client.setFirstName(rs.getString("NAME"));
                client.setLastName(rs.getString("LAST_NAME"));
                client.setPhone(rs.getString("PHONE"));
                client.setEmail(rs.getString("EMAIL"));
                client.setPassport(rs.getString("PASSPORT"));
                result.add(client);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Client client) throws PersistException {
        try {
            int id;
            if (client.getId() == 0) id = 1;
            else id = client.getId();
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getPassport());
            statement.setString(4, client.getPhone());
            statement.setString(5, client.getEmail());
            statement.setInt(6, id);
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Client client) throws PersistException {
        try {
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getPassport());
            statement.setString(4, client.getPhone());
            statement.setString(5, client.getEmail());
            statement.setInt(6, client.getId());

        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    public Client create() throws SQLException, PersistException {
        Client client = new Client();
        return persist(client);
    }

    private class PersistClient extends Client {
        @Override
        public void setId(int id) {
            super.setId(id);
        }
    }
}