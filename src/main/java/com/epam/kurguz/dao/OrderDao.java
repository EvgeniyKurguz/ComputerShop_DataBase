package com.epam.kurguz.dao;

import com.epam.kurguz.entity.Order;
import com.epam.kurguz.exception.DaoException;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> getOrderList() throws DaoException;

}


