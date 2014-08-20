package com.epam.kurguz.dao;


import com.epam.kurguz.dao.h2.H2ClientDao;
import com.epam.kurguz.entity.Client;
import com.epam.kurguz.exception.PersistException;

import java.sql.ResultSet;
import java.util.List;

public class ClientDao implements H2ClientDao {

    public ClientDao() {
        super();
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
    public List<Client> parseResultSet(ResultSet rs) throws PersistException {
        return null;
    }

    @Override
//    public List<Client> parseResultSet(ResultSet rs) throws PersistException {
//        LinkedList<Client> result = new LinkedList<Client>();
//        try {
//            while (rs.next()) {
//                Client client = new Client();
//                client.setId(rs.getInt("ID"));
//                client.setFirstName(rs.getString("NAME"));
//                client.setLastName(rs.getString("LAST_NAME"));
//                client.setPhone(rs.getString("PHONE"));
//                client.setEmail(rs.getString("EMAIL"));
//                client.setIdentityPapers(rs.getString("IDENTITY_PAPERS"));
//                result.add(client);
//            }
//        } catch (Exception e) {
//            throw new PersistException(e);
//        }
//        return result;
//    }


    public String insertClient() {
        return null;
    }

    @Override
    public String selectClient() {
        return null;
    }

    @Override
    public String updateClient() {
        return null;
    }

    @Override
    public String deleteClient() {
        return null;
    }
}