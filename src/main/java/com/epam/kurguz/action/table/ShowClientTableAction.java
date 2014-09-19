package com.epam.kurguz.action.table;

import com.epam.kurguz.action.Action;
import com.epam.kurguz.action.ActionResult;
import com.epam.kurguz.dao.ClientDao;
import com.epam.kurguz.dao.DaoManager;
import com.epam.kurguz.dao.h2.H2DaoFactory;
import com.epam.kurguz.entity.Client;
import com.epam.kurguz.exception.ActionException;
import com.epam.kurguz.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ShowClientTableAction implements Action {
    public static final Logger LOGGER = LoggerFactory.getLogger(ShowClientTableAction.class);
    public static final int DEFAULT_PAGE_NUMBER = 0;
    public static final int DEFAULT_ROWS_COUNT = 10;
    private ActionResult clientTable = new ActionResult("clientTable");

    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException {
        int pageNumber = DEFAULT_PAGE_NUMBER;
        int rowsCount = DEFAULT_ROWS_COUNT;
        String pageName = request.getParameter("clientTable");
        String pageString = request.getParameter("page");
        String rowsString = request.getParameter("rows");

        if (pageString != null) pageNumber = Integer.valueOf(pageString);
        if (rowsString != null) rowsCount = Integer.valueOf(rowsString);

        DaoManager daoManager = null;
        try {
            H2DaoFactory factory = new H2DaoFactory();
            daoManager = factory.getDaoManager();
            ClientDao clientDao = daoManager.getClientDao();
            List<Client> clientList = clientDao.findRange(pageNumber, rowsCount);
            List<Client> clientLengthList = clientDao.getClientList();

            int tableLength = clientLengthList.size();
            List<Integer> paginationList = new ArrayList<>();

            for (int i = 0; i < tableLength / rowsCount + 1; i++) {
                paginationList.add(i + 1);
            }

            if (pageNumber == tableLength / rowsCount + 1) {
                request.setAttribute("nextDisabled", "disabled");
            }

            if (pageNumber == 1) {
                request.setAttribute("backDisabled", "disabled");
            }

            request.setAttribute("paginationList", paginationList);
            request.setAttribute("clientList", clientList);
            request.setAttribute("pageNumber", pageNumber);
            request.setAttribute("rowsCount", rowsCount);
            request.setAttribute("pageName", pageName);
            daoManager.commit();
        } catch (DaoException e) {
            try {
                daoManager.rollBack();
            request.setAttribute("EditClientError", "Edit client error");
            } catch (DaoException exception) {
                throw new ActionException(exception);
            }
        } finally {
            try {
                daoManager.close();
            } catch (DaoException e) {
                throw new ActionException(e);
            }
        }
        return clientTable;
    }
}

