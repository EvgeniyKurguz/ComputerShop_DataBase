package com.epam.kurguz.dao;


import com.epam.kurguz.entity.Employee;

import java.util.List;

public interface EmployeeDao<T> extends Dao<Employee> {

    T getByPost(String post) throws DaoException;

    T getByLastName(String lastName) throws DaoException;

    void deleteByLastName(String lastName) throws DaoException;

    List<T> getEmployeeList() throws DaoException;
}
