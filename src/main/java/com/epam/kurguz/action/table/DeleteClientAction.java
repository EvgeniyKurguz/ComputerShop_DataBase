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

public class DeleteClientAction implements Action {
    private ActionResult deleteClient = new ActionResult("clientTable", true);

    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException {
        String delete = request.getParameter("delete");

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
        if (delete != null) {
            Client findClient = null;
            try {
                int id = Integer.parseInt(delete);
                findClient = clientDao.findById(id);
            } catch (DaoException e) {
                throw new ActionException(e);
            }
            try {
                clientDao.deleteById(findClient);
            } catch (DaoException e) {
                throw new ActionException(e);
            }
        }
        return deleteClient;
    }
}


