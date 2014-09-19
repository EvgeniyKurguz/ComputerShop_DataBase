package com.epam.kurguz.dao;


import com.epam.kurguz.exception.DaoException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoHelper {

    public static void closeResultSet(ResultSet resultSet) throws DaoException {
        try {
            if (resultSet != null) resultSet.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static void closeInputStream(InputStream inputStream) throws DaoException {
        try {
            if (inputStream != null) inputStream.close();
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }

    public static void closeOutputStream(OutputStream outputStream) throws DaoException {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }
    public static void closeAll(ResultSet rs, InputStream is, OutputStream os) throws DaoException{
        closeResultSet(rs);
        closeInputStream(is);
        closeOutputStream(os);
    }
}

