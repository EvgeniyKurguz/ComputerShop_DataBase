package com.epam.kurguz.dao;


import com.epam.kurguz.dao.h2.H2ClientDao;

public class ClientDao extends UserDao implements H2ClientDao {

    @Override
    public String insertClient() {
        return "INSERT INTO  CLIENTS(FIRSTNAME, LASTNAME, BIRTH, PHONE, ATTESTATION_NUMBER, EMAIL) \n" +
                "VALUES (?, ?, ?, ?, ?, ?);";    }

    @Override
    public String selectClient() {
        return "SELECT ID, FIRSTNAME, LASTNAME, BIRTH, PHONE, ATTESTATION_NUMBER, EMAIL FROM CLIENTS";
    }

    @Override
    public String updateClient() {
        return "UPDATE  CLIENTS \n" +
                "SET FIRSTNAME = ?, LASTNAME = ?, BIRTH = ?, PHONE = ?, ATTESTATION_NUMBER= ?, EMAIL= ? \n" +
                "WHERE ID = ?;";
    }

    @Override
    public String deleteClient() {
        return "DELETE FROM CLIENTS WHERE ID= ?;";
    }
}