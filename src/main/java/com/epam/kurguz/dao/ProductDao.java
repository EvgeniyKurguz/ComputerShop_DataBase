package com.epam.kurguz.dao;


import com.epam.kurguz.entity.Product;
import com.epam.kurguz.exception.DaoException;

import java.util.List;

public interface ProductDao extends Dao<Product> {
    Product findByName(String name) throws DaoException;

    Product findByMaker(String maker) throws DaoException;

    Product findByModel(String model) throws DaoException;

    void deleteByName(Product product) throws DaoException;

    void setDeleteByMaker(Product product) throws DaoException;

    void setDeleteByModel(Product product) throws DaoException;

    List<Product> findRange(int limit, int offset) throws DaoException;

    List<Product> getProductList() throws DaoException;

}