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
    private static BoneCP connectionPool;
    private static BoneCPConfig config;
    private static Connection connection;

    public H2DaoFactory() throws DaoException {
        try {
            Class.forName(propertyManager.getProperty("db.driver"));
            if (connectionPool == null) {
                if (config == null) {
                    config = getConfig(PROPERTIES_FILE);
                }
                connectionPool = new BoneCP(config);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException(e);
        }
    }

    public static BoneCPConfig getConfig(String propertyFileName) {
        String jdbcUrl = propertyManager.getProperty("db.url");
        String username = propertyManager.getProperty("db.user");
        String password = propertyManager.getProperty("db.password");
        int maxConn = Integer.parseInt(propertyManager.getProperty("db.poolsize"));

        BoneCPConfig config = new BoneCPConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setMaxConnectionsPerPartition(maxConn);

        return config;
    }

    @Override
    public Connection getConnection() throws DaoException {
        try {
            if (connection == null || connection.isClosed()) {
                connection = connectionPool.getConnection();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return connection;
    }

    @Override
    public DaoManager getDaoManager() throws DaoException {
        return new H2DaoManager(getConnection());
    }
}
