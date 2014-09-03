package com.epam.kurguz;

import com.epam.kurguz.dao.h2.H2ClientDao;
import com.epam.kurguz.dao.h2.H2DaoFactory;
import com.epam.kurguz.entity.Client;
import com.epam.kurguz.exception.DaoException;

import java.util.List;


public class Main {
    public static void main(String[] args) throws DaoException {
        H2DaoFactory instance = (H2DaoFactory) H2DaoFactory.getInstance();
        H2ClientDao clientDao = instance.getClientDao();
        List<Client> clientList = clientDao.getClientList();
        System.out.println(clientList);
    }
}
