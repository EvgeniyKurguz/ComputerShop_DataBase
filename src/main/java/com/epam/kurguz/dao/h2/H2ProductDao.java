package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.DaoHelper;
import com.epam.kurguz.dao.JDBCDao;
import com.epam.kurguz.dao.ProductDao;

import com.epam.kurguz.entity.Product;
import com.epam.kurguz.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class H2ProductDao extends JDBCDao implements ProductDao {
    private static final String JOIN =" inner join MAKER on product.city_id = MAKER.ID" +
            " inner join MODEL on product.country_id = MODEL.ID";

    private static final String FIND_BY_ID = "SELECT * FROM product " + JOIN + " WHERE product.ID=?";
    private static final String FIND_BY_NAME = "SELECT * FROM product " + JOIN + " WHERE LASTNAME=?";
    private static final String FIND_BY_MAKER = "SELECT * FROM product " + JOIN + " WHERE MAKER=?";
    private static final String FIND_BY_MODEL = "SELECT * FROM product " + JOIN + " WHERE MODEL=?";

    private static final String GET_PRODUCT_LIST = "SELECT * FROM product " + JOIN;
    private static final String FIND_RANGE = "SELECT * FROM product " + JOIN + "product.ID LIMIT ? OFFSET ?";
    private static final String DELETE_BY_ID = "UPDATE product  WHERE ID = ?";
    private static final String DELETE_BY_NAME = "DELETE FROM product WHERE NAME =?";
    private static final String DELETE_BY_MAKER = "DELETE FROM product WHERE MAKER=?";
    private static final String DELETE_BY_MODEL = "DELETE FROM product WHERE MODEL=?";
    private static final String UPDATE = "UPDATE  product" +
            " SET NAME = ?, MAKER = ?, MODEL = ?, ";
    private static final String CREATE_PRODUCT = "INSERT INTO product VALUES (default, ?, ?, ?, )";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String MAKER = "maker";
    private static final String MODEL = "model";

    public H2ProductDao(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public void update(Product product) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getMaker());
            preparedStatement.setString(3, product.getModel());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void insert(Product product) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getMaker());
            preparedStatement.setString(3, product.getModel());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Product findById(int id) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            return getProductFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }


    @Override
    public Product findByName(String name) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME)) {
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            return getProductFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public Product findByMaker(String maker) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_MAKER)) {
            preparedStatement.setString(1, maker);
            resultSet = preparedStatement.executeQuery();
            return getProductFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public Product findByModel(String model) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_MODEL)) {
            preparedStatement.setString(1, model);
            resultSet = preparedStatement.executeQuery();
            return getProductFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public void deleteByName(Product product) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_NAME)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void setDeleteByMaker(Product product) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_MAKER)) {
            preparedStatement.setString(1, product.getMaker());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void setDeleteByModel(Product product) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_MODEL)) {
            preparedStatement.setString(1, product.getModel());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Product> findRange(int limit, int offset) throws DaoException {
        ResultSet resultSet = null;
        List<Product> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_RANGE)) {
            preparedStatement.setInt(1, offset);
            preparedStatement.setInt(2, limit);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(createProduct(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
        return result;
    }

    @Override
    public void deleteById(Product product) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setInt(1, product.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


    @Override
    public List<Product> getProductList() throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_LIST)) {
            List<Product> products = new ArrayList<Product>();
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(createProduct(resultSet));
            }
            return products;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    private Product getProductFromResultSet(ResultSet resultSet) throws DaoException {
        Product product = null;
        try {
            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt(ID));
                product.setName(resultSet.getString(NAME));
                product.setMaker(resultSet.getString(MAKER));
                product.setModel(resultSet.getString(MODEL));

            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return product;
    }

    private Product createProduct(ResultSet resultSet) throws DaoException {
        try {
            int id = resultSet.getInt(ID);
            String name = resultSet.getString(NAME);
            String maker = resultSet.getString(MAKER);
            String model = resultSet.getString(MODEL);

            return new Product.Builder()
                    .id(id)
                    .name(name)
                    .maker(maker)
                    .model(model)
                    .build();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}

