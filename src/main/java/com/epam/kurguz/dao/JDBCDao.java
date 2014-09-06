package com.epam.kurguz.dao;

import java.sql.Connection;

public abstract class JDBCDao {
    public Connection connection;

    public JDBCDao(Connection connection) {
    }
}
