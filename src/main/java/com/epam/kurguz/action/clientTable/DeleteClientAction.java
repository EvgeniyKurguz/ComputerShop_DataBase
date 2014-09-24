package com.epam.kurguz.action.clientTable;


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

public class DeleteClientAction implements Action {
    private ActionResult deleteClient = new ActionResult("clientTable", true);

    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException {
        String delete = request.getParameter("delete");
        DaoManager daoManager = null;
        try {
            DaoFactory factory = H2DaoFactory.getInstance();
            daoManager = factory.getDaoManager();
            ClientDao clientDao = daoManager.getClientDao();
            if (delete != null) {
                int id = Integer.parseInt(delete);
                Client findClient = clientDao.findById(id);
                clientDao.deleteById(findClient);
            }
            daoManager.commit();
        } catch (DaoException e){
            try {
                daoManager.rollBack();
                request.setAttribute("DeleteClientError", "Delete client error");
            } catch (DaoException exception) {
                throw new ActionException(exception);
            }
        }finally {
            try {
                daoManager.close();
            } catch (DaoException e) {
                throw new ActionException(e);
            }
        }
        return deleteClient;
    }
}
