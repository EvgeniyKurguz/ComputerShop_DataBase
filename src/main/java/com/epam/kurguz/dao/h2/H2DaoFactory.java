package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.ClientDao;
import com.epam.kurguz.dao.DaoFactory;

public class H2DaoFactory implements DaoFactory {
    @Override
    public ClientDao getClientDao() {
        return null;
    }

    @Override
    public H2EmployeeDao getEmployeeDao() {
        return null;
    }
//    public static final String PROPERTIES_FILE = "database.properties";
//    private static BoneCP connectionPool;
//    private static BoneCPConfig config;
//    private static PropertyManager propertyManager = new PropertyManager(PROPERTIES_FILE);
//
//
//    public static BoneCPConfig getConfig(String propertyFileName) {
//        String jdbcUrl = propertyManager.getProperty("db.url");
//        String username = propertyManager.getProperty("db.user");
//        String password = propertyManager.getProperty("db.password");
//        int maxConn = Integer.parseInt(propertyManager.getProperty("db.poolsize"));
//
//        BoneCPConfig config = new BoneCPConfig();
//        config.setJdbcUrl(jdbcUrl);
//        config.setUsername(username);
//        config.setPassword(password);
//        config.setMaxConnectionsPerPartition(maxConn);
//
//        return config;
//    }
//
//    public static BoneCP getH2ConnectionPool() throws PoolException {
//        try {
//            Class.forName("org.h2.Driver");
//            if (connectionPool == null) {
//                if (config == null) {
//                    config = getConfig(PROPERTIES_FILE);
//                }
//                connectionPool = new BoneCP(config);
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new PoolException();
//        }
//        return connectionPool;
//    }
//
//    @Override
//    public H2ClientDao getClientDao() {
//        return new H2ClientDao();
//    }
//
//    @Override
//    public H2EmployeeDao getEmployeeDao() {
//        return null;
//    }

}
