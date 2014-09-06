package com.epam.kurguz.action.table;


import com.epam.kurguz.action.Action;
import com.epam.kurguz.action.ActionResult;
import com.epam.kurguz.dao.ClientDao;
import com.epam.kurguz.dao.DaoManager;
import com.epam.kurguz.dao.h2.H2DaoFactory;
import com.epam.kurguz.entity.Client;
import com.epam.kurguz.exception.ActionException;
import com.epam.kurguz.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ClientTableAction implements Action {

    private ActionResult clientTable = new ActionResult("clientTable");

    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException {

        H2DaoFactory factory = null;
        try {
            factory = new H2DaoFactory();
        } catch (DaoException e) {
            throw new ActionException(e);
        }
        DaoManager daoManager = null;
        try {
            daoManager = factory.getDaoManager();
        } catch (DaoException e) {
            throw new ActionException(e);
        }
        ClientDao clientDao = null;
        try {
            clientDao = daoManager.getClientDao();
        } catch (DaoException e) {
            throw new ActionException(e);
        }

        List<Client> clientList = null;
        try {
            clientList = clientDao.getClientList();
        } catch (DaoException e) {
            throw new ActionException(e);
        }

        request.setAttribute("clientList", clientList);
        return clientTable;
    }

}
