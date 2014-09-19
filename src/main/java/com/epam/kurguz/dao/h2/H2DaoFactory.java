package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.DaoFactory;
import com.epam.kurguz.dao.DaoManager;
import com.epam.kurguz.exception.DaoException;
import com.epam.kurguz.pool.PropertyManager;
import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

import java.sql.Connection;
import java.sql.SQLException;

public class H2DaoFactory implements DaoFactory {
    public static final String PROPERTIES_FILE = "database.properties";
    private static PropertyManager propertyManager = new PropertyManager(PROPERTIES_FILE);
    private final BoneCP connectionPool;

    public H2DaoFactory() throws DaoException {
        try {
            Class.forName(propertyManager.getProperty("db.driver"));
        } catch (ClassNotFoundException e) {
            throw new DaoException(e);
        }
        BoneCPConfig config = new BoneCPConfig();

        config.setJdbcUrl(propertyManager.getProperty("db.url"));
        config.setUsername(propertyManager.getProperty("db.user"));
        config.setPassword(propertyManager.getProperty("db.password"));

        try {
            connectionPool = new BoneCP(config);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static DaoFactory getInstance() {
        return InstanceHolder.instance;
    }

    public DaoManager getDaoManager() throws DaoException {
        Connection connection;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return new H2DaoManager(connection);
    }

    private static class InstanceHolder {
        private static DaoFactory instance = new H2DaoFactory();
    }

}