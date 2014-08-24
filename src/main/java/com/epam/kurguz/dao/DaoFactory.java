package com.epam.kurguz.dao;

public interface DaoFactory {

    public ClientDao getClientDao();

    public com.epam.kurguz.dao.h2.H2EmployeeDao getEmployeeDao();
    }
