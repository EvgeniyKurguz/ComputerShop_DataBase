package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.JDBCDao;
import com.epam.kurguz.dao.OrderDao;
import com.epam.kurguz.entity.Order;
import com.epam.kurguz.exception.DaoException;

import java.sql.Connection;
import java.util.List;


public class H2OrderDao extends JDBCDao implements OrderDao {
    public H2OrderDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Order> getOrderList() throws DaoException {
        return null;
    }

    @Override
    public void insert(Order entityToCreate) throws DaoException {

    }

    @Override
    public Order findById(int id) throws DaoException {
        return null;
    }

    @Override
    public void update(Order entityToUpdate) throws DaoException {

    }

    @Override
    public void deleteById(Order entityToDelete) throws DaoException {

    }
}