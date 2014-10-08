package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.DaoHelper;
import com.epam.kurguz.dao.JDBCDao;
import com.epam.kurguz.dao.ProductDao;
import com.epam.kurguz.entity.PaginatedList;
import com.epam.kurguz.entity.Product;
import com.epam.kurguz.entity.PropertyValue;
import com.epam.kurguz.exception.DaoException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class H2ProductDao extends JDBCDao implements ProductDao {
    public static final String JOIN = "inner join country on product.country_id = country.id";
    private static final String FIND_BY_ID = "SELECT * FROM product " + JOIN + " WHERE product.ID=?";
    private static final String FIND_RANGE = "SELECT * FROM product " + JOIN + " WHERE NOT is_blocked ORDER BY product.ID LIMIT ? OFFSET ?";
    private static final String GET_PRODUCT_LIST = "SELECT * FROM product " + JOIN + " WHERE product.is_blocked='FALSE'";
    private static final String CREATE_PRODUCT = "INSERT INTO product VALUES (default, ?," +
            " ?, ?, (SELECT id FROM image WHERE filename = ?), ?, ?, ?, ?," +
            " ?,false)";
    private static final String FIND_BY_CATEGORY = "select * from property_value inner join " +
            "reference_property on property_value.reference_property_id  = reference_property.ID ";

    private static final String UPDATE = "UPDATE product" +
            " SET Name = ?, Model_id=(SELECT id FROM Model WHERE Model = ?)," +
            " Maker = ?," +
            " price = ?, quantity = ?, weight = ? WHERE ID = ?";
    private static final String DELETE_BY_ID = "UPDATE product SET is_blocked = 'TRUE' WHERE ID = ?";
    public static final String GET_COUNT = "SELECT COUNT(*) FROM product";
    private static final String ID = "id";
    private static final String PRODUCT_NAME = "name";
    private static final String MAKER = "maker";
    private static final String MODEL = "model";
    private static final String IS_BLOCKED = "is_blocked";
    private static final String PRICE = "price";
    private static final String QUANTITY = "quantity";
    private static final String WEIGHT = "weight";
    private static final String NAME = "name";
    private static final String VALUE = "value";


    public H2ProductDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectRequest() throws DaoException {
        return GET_PRODUCT_LIST;
    }

    @Override
    public String getSelectCount() throws DaoException {
        return GET_COUNT;
    }

    @Override
    public String getSelectRequestByRange() throws DaoException {
        return FIND_RANGE;
    }

    @Override
    public void insert(Product product) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getMaker());
            preparedStatement.setString(3, product.getModel());
            preparedStatement.setBigDecimal(4, product.getPrice());
            preparedStatement.setInt(5, product.getQuantity());
            preparedStatement.setInt(6, product.getWeight());
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
            return getFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public void update(Product product) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getMaker());
            preparedStatement.setString(3, product.getModel());
            preparedStatement.setBigDecimal(4, product.getPrice());
            preparedStatement.setInt(5, product.getQuantity());
            preparedStatement.setInt(6, product.getWeight());
            preparedStatement.setInt(7, product.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
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
    public List<Product> findAll() throws DaoException {
        return null;
    }

    @Override
    public PaginatedList<Product> findRange(int pageNumber, int rowsCount) throws DaoException {
        return null;
    }

    @Override
    public int getCount() throws DaoException {
        return 0;
    }

    @Override
    public Product findByName(String lastName) throws DaoException {
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
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_LIST)) {
            List<Product> products = new ArrayList<>();
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(createEntity(resultSet));
            }
            return products;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public List<PropertyValue> findByPropertyNameAndCategory(String category, String propertyName) throws DaoException {
        ResultSet resultSet = null;
        List<PropertyValue> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_CATEGORY)) {
            preparedStatement.setString(1, category);
            preparedStatement.setString(2, propertyName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(createPropertyValue(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
        return result;
    }

    @Override
    public Product createEntity(ResultSet resultSet) throws DaoException {

        try {
            int id = resultSet.getInt(ID);
            String productName = resultSet.getString(PRODUCT_NAME);
            String maker = resultSet.getString(MAKER);
            String model = resultSet.getString(MODEL);
            BigDecimal price = resultSet.getBigDecimal(PRICE);
            int quantity = resultSet.getInt(QUANTITY);
            int weight = resultSet.getInt(WEIGHT);
            boolean blocked = resultSet.getBoolean(IS_BLOCKED);
            return new Product.Builder()
                    .id(id)
                    .name(productName)
                    .maker(maker)
                    .model(model)
                    .price(price)
                    .quantity(quantity)
                    .weight(weight)
                    .blocked(blocked)
                    .build();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private PropertyValue createPropertyValue(ResultSet resultSet) throws DaoException {
        try {
            int id = resultSet.getInt(ID);
            String name = resultSet.getString(NAME);
            String value = resultSet.getString(VALUE);
            return new PropertyValue.Builder()
                    .id(id)
                    .name(name)
                    .value(value)
                    .build();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Product getFromResultSet(ResultSet resultSet) throws DaoException {
        Product product = null;
         try {
            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt(ID));
                product.setName(resultSet.getString(PRODUCT_NAME));
                product.setMaker(resultSet.getString(MAKER));
                product.setModel(resultSet.getString(MODEL));
                product.setPrice(resultSet.getBigDecimal(PRICE));
                product.setQuantity(resultSet.getInt(QUANTITY));
                product.setWeight(resultSet.getInt(WEIGHT));
                product.setBlocked(resultSet.getBoolean(IS_BLOCKED));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return product;
    }

}



