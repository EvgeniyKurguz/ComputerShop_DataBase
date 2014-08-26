package com.epam.kurguz.dao;


import com.epam.kurguz.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao<T> extends Dao<Employee> {

    Employee getByPost(String post) throws DaoException;

    Employee getByLastName(String lastName) throws DaoException;

    void insert(Employee employee) throws DaoException;

    void update(Employee employee) throws DaoException, SQLException;

    void delete(int id) throws DaoException, SQLException;

    void deleteByLastName(String lastName) throws DaoException;

    List<Employee> getEmployeeList() throws DaoException;

    Employee findEmployeeByUsernameAndPassword(String username, String password) throws DaoException;
}
