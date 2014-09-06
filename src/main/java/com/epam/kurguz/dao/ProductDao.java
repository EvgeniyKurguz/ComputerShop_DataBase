package com.epam.kurguz.dao;


import com.epam.kurguz.entity.Product;
import com.epam.kurguz.exception.DaoException;

import java.util.List;

public interface ProductDao extends Dao<Product> {
    Product findByProductName(String lastName) throws DaoException;

    Product findByProducer(String username) throws DaoException;

    void deleteByProductName(Product client) throws DaoException;

    void deleteByProducer(Product client) throws DaoException;

    List<Product> getProductList() throws DaoException;
}