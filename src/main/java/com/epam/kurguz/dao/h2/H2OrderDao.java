package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.ClientDao;
import com.epam.kurguz.dao.DaoHelper;
import com.epam.kurguz.dao.JDBCDao;
import com.epam.kurguz.dao.OrderDao;
import com.epam.kurguz.entity.Client;
import com.epam.kurguz.entity.Order;
import com.epam.kurguz.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class H2OrderDao extends JDBCDao<Order> implements OrderDao {
    private static final String IS_BLOCKED = "is_blocked";
    private static final String ID = "id";
    private static final String GET_ORDER_LIST = "SELECT * FROM booking inner join client on booking.client_id = client.id WHERE booking.is_blocked='FALSE'";
    private static final String CREATE_ORDER = "INSERT INTO booking VALUES (default, ?, ?)";
    private static final String STATUS = "status";

    public H2OrderDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectRequest() throws DaoException {
        return null;
    }

    @Override
    public String getSelectCount() throws DaoException {
        return null;
    }

    @Override
    public String getSelectRequestByRange() throws DaoException {
        return null;
    }

    @Override
    public Order getFromResultSet(ResultSet resultSet) throws DaoException {
        return null;
    }


    @Override
    public void insert(Order order) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement( CREATE_ORDER)) {
            preparedStatement.setInt(1, order.getClient().getId());
            preparedStatement.setInt(2, order.getStatus().getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
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

    @Override
    public List<Order> getOrderList() throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_LIST)) {
            List<Order> bookings = new ArrayList<>();
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookings.add(createEntity(resultSet));
            }
            return bookings;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public Order createEntity(ResultSet resultSet) throws DaoException {
        ClientDao clientDao = new H2ClientDao(connection);
        try {
            int id = resultSet.getInt(ID);
            Client client = clientDao.findById(resultSet.getInt(ID));
            String status = resultSet.getString(STATUS);
            return new Order.Builder()
                    .id(id)
                    .client(client)
                    .build();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
