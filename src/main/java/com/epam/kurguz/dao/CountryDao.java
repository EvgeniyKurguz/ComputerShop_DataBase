package com.epam.kurguz.dao;


import com.epam.kurguz.entity.Country;
import com.epam.kurguz.exception.DaoException;

import java.util.List;

public interface CountryDao extends Dao<Country> {
    List<Country> getCountryList() throws DaoException;

    Country findByName(String countryName) throws DaoException;
}

