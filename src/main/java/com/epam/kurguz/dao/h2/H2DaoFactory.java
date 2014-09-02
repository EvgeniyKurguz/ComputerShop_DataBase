package com.epam.kurguz.dao.h2;

import com.epam.kurguz.entity.Employee;
import com.epam.kurguz.exception.DaoException;
import com.epam.kurguz.dao.DaoFactory;
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
    private static H2DaoFactory instance = new H2DaoFactory();

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

    private H2DaoFactory() {
        try {
            Class.forName(propertyManager.getProperty("db.driver"));
            if (connectionPool == null) {
                if (config == null) {
                    config = getConfig(PROPERTIES_FILE);
                }
                connectionPool = new BoneCP(config);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    @Override
    public H2ClientDao getClientDao() throws DaoException {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return new H2ClientDao(connection) {
            @Override
            public void insert(Object entityToCreate) throws DaoException {

            }

            @Override
            public void update(Object entityToUpdate) throws DaoException {

            }

            @Override
            public void deleteById(Object entityToDelete) throws DaoException {

            }
        };
    }

    @Override
    public H2EmployeeDao getEmployeeDao() throws DaoException {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return new H2EmployeeDao(connection) {
            @Override
            public Employee findByLastName(String lastName) throws DaoException {
                return null;
            }

            @Override
            public void deleteByLastName(Employee employee) throws DaoException {

            }

            @Override
            public boolean employeeLoginIsOccupied(String username) throws DaoException {
                return false;
            }

            @Override
            public void insert(Object entityToCreate) throws DaoException, SQLException {

            }

                       @Override
            public void update(Object entityToUpdate) throws DaoException {

            }

            @Override
            public void deleteById(Object entityToDelete) throws DaoException {

            }
        };
    }

    @Override
    public H2UserDao getUserDao() throws DaoException {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return new H2UserDao(connection);
    }
}
