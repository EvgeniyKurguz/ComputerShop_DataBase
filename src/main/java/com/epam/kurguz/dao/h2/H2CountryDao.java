package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.CountryDao;
import com.epam.kurguz.dao.DaoHelper;
import com.epam.kurguz.dao.JDBCDao;
import com.epam.kurguz.entity.Country;
import com.epam.kurguz.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class H2CountryDao extends JDBCDao<Country> implements CountryDao {
    private static final String FIND_BY_ID = "SELECT id, name FROM country WHERE id = ?";
    private static final String GET_COUNTRY_LIST = "SELECT * FROM country";
    private static final String FIND_BY_COUNTRY_NAME = "SELECT id, name FROM country WHERE name = ?";
    private static final String ID = "id";
    private static final String NAME = "name";

    public H2CountryDao(Connection connection) {
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
    public Country getFromResultSet(ResultSet resultSet) throws DaoException {
        Country country = null;
        try {
            if (resultSet.next()) {
                country = new Country();
                country.setId(resultSet.getInt(ID));
                country.setName(resultSet.getString(NAME));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return country;
    }

    @Override
    public Country createEntity(ResultSet resultSet) throws DaoException {
        try {
            int id = resultSet.getInt(ID);
            String name = resultSet.getString(NAME);
            return new Country.Builder()
                    .id(id)
                    .name(name)
                    .build();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void insert(Country entityToCreate) throws DaoException {

    }

    @Override
    public Country findById(int id) throws DaoException {
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
    public void update(Country entityToUpdate) throws DaoException {

    }

    @Override
    public void deleteById(Country entityToDelete) throws DaoException {

    }

    @Override
    public List<Country> getCountryList() throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_COUNTRY_LIST)) {
            List<Country> countries = new ArrayList<>();
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    countries.add(createEntity(resultSet));
                }
                return countries;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Country findByName(String countryName) {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_COUNTRY_NAME)) {
            preparedStatement.setString(1, countryName);
            resultSet = preparedStatement.executeQuery();
            return getFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }
}