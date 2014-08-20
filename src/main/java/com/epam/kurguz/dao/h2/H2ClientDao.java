package com.epam.kurguz.dao.h2;

import com.epam.kurguz.entity.Client;
import com.epam.kurguz.exception.PersistException;
import java.sql.ResultSet;
import java.util.List;

public interface H2ClientDao {
    String getSelectQuery();

    String getCreateQuery();

    String getUpdateQuery();

    String getDeleteQuery();

    List<Client> parseResultSet(ResultSet rs) throws PersistException;

    public String insertClient();
    public String selectClient();
    public String updateClient();
    public String deleteClient();
   }
