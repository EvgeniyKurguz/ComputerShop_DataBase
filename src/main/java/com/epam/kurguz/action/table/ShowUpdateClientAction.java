package com.epam.kurguz.action.table;


import com.epam.kurguz.action.Action;
import com.epam.kurguz.action.ActionResult;
import com.epam.kurguz.dao.ClientDao;
import com.epam.kurguz.dao.DaoFactory;
import com.epam.kurguz.dao.DaoManager;
import com.epam.kurguz.dao.h2.H2DaoFactory;
import com.epam.kurguz.entity.Client;
import com.epam.kurguz.exception.ActionException;
import com.epam.kurguz.exception.DaoException;

import javax.servlet.http.HttpServletRequest;

public class ShowUpdateClientAction implements Action {
    private final static String ID = "id";
    private ActionResult updateClient = new ActionResult("updateClient");

    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException {
        String update = request.getParameter(ID);
        int id = Integer.parseInt(update);

        DaoManager daoManager = null;
        try {
            DaoFactory factory = H2DaoFactory.getInstance();
            daoManager = factory.getDaoManager();
            ClientDao clientDao = daoManager.getClientDao();

            Client client = clientDao.findById(id);
            request.setAttribute("user", client);
            daoManager.commit();
        } catch (DaoException e) {
            daoManager.rollBack();
            request.setAttribute("ShowUpdateClientError", "Show update client error");
        } finally {
            daoManager.close();
        }
        return updateClient;
    }
}

