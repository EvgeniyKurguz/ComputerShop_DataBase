package com.epam.kurguz.dao;


import com.epam.kurguz.entity.Employee;
import com.epam.kurguz.exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao extends Dao<Employee> {

    void insert(Employee employee) throws DaoException, SQLException;

    Employee findByLastName(String lastName) throws DaoException;

    void update(Employee employee) throws DaoException;

    void deleteById(Employee employee) throws DaoException;

    void deleteByLastName(Employee employee) throws DaoException;

    List<Employee> getEmployeeList() throws DaoException;

    Employee findEmployeeByUsernameAndPassword(String username, String password) throws DaoException;

    boolean employeeLoginIsOccupied(String username) throws DaoException;
}
