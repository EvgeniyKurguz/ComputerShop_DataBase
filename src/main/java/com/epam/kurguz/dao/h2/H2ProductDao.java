package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.JDBCDao;
import com.epam.kurguz.dao.ProductDao;
import com.epam.kurguz.entity.Product;
import com.epam.kurguz.exception.DaoException;

import java.sql.Connection;
import java.util.List;


public class H2ProductDao extends JDBCDao implements ProductDao {
    public H2ProductDao(Connection connection) {
        super(connection);
    }

    @Override
    public Product findByProductName(String lastName) throws DaoException {
        return null;
    }

    @Override
    public Product findByProducer(String username) throws DaoException {
        return null;
    }

    @Override
    public void deleteByProductName(Product client) throws DaoException {

    }

    @Override
    public void deleteByProducer(Product client) throws DaoException {

    }

    @Override
    public List<Product> getProductList() throws DaoException {
        return null;
    }

    @Override
    public void insert(Product entityToCreate) throws DaoException {

    }

    @Override
    public Product findById(int id) throws DaoException {
        return null;
    }

    @Override
    public void update(Product entityToUpdate) throws DaoException {

    }

    @Override
    public void deleteById(Product entityToDelete) throws DaoException {

    }
}