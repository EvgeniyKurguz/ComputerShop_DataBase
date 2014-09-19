package com.epam.kurguz.dao;

import com.epam.kurguz.exception.DaoException;

public interface DaoFactory {

    public DaoManager getDaoManager() throws DaoException;
}
