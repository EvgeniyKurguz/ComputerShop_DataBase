package com.epam.kurguz.dao;


import com.epam.kurguz.entity.Product;
import com.epam.kurguz.entity.PropertyValue;
import com.epam.kurguz.exception.DaoException;

import java.sql.ResultSet;
import java.util.List;

public interface ProductDao extends Dao<Product> {
    String getSelectRequest() throws DaoException;

    String getSelectCount() throws DaoException;

    String getSelectRequestByRange() throws DaoException;

    Product findByName(String lastName) throws DaoException;

    Product findByProducer(String username) throws DaoException;

    void deleteByProductName(Product client) throws DaoException;

    void deleteByProducer(Product client) throws DaoException;

    List<Product> getProductList() throws DaoException;

    List<PropertyValue> findByPropertyNameAndCategory(String propertyName, String category) throws DaoException;

    Product createEntity(ResultSet resultSet) throws DaoException;

    Product getFromResultSet(ResultSet resultSet) throws DaoException;
}