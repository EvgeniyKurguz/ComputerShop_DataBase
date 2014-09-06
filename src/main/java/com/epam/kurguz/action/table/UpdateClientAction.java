package com.epam.kurguz.action.table;


import com.epam.kurguz.action.Action;
import com.epam.kurguz.action.ActionResult;
import com.epam.kurguz.dao.h2.H2ClientDao;
import com.epam.kurguz.dao.h2.H2DaoFactory;
import com.epam.kurguz.entity.Client;
import com.epam.kurguz.exception.ActionException;
import com.epam.kurguz.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class UpdateClientAction implements Action {
    private static final String CLIENT = "CLIENT";
    private static final String FIRSTNAME = "firstName";
    private static final String LASTNAME = "lastName";
    private static final String BIRTH = "birth";

    private static final String PHONE = "phone";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";
    private static final String CITY = "city";
    private static final String COUNTRY = "country";
    public static final Logger LOGGER = LoggerFactory.getLogger(ClientTableAction.class);
    ActionResult clientTable = new ActionResult("clientTable",true);

    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException {
        String firstName = request.getParameter(FIRSTNAME);
        String lastName = request.getParameter(LASTNAME);
        String birth = request.getParameter(BIRTH);
        String phone = request.getParameter(PHONE);
        String username = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);
        String email = request.getParameter(EMAIL);
        String city = request.getParameter(CITY);
        String country = request.getParameter(COUNTRY);
        String update = request.getParameter("update");

        H2DaoFactory factory =  H2DaoFactory.getInstance();
        H2ClientDao clientDao;
        try {
            clientDao = factory.getClientDao();
        } catch (DaoException e) {
            throw new ActionException(e);
        }
        if (update != null) {
            int id = Integer.parseInt(update);
            Client findClient = null;
            try {
                 findClient = clientDao.findById(id);
            } catch (DaoException e) {
                throw new ActionException(e);
            }
            Client client = new Client();
            client.setFirstName(firstName);
            client.setLastName(lastName);
            client.setBirth(Date.valueOf(birth));
            client.setPhone(phone);
            client.setEmail(email);
            client.setUserName(username);
            client.setPassword(password);
            client.setCity(city);
            client.setCountry(country);
            client.setId(id);
            try {
                clientDao.update(client);
            } catch (DaoException e) {
                throw new ActionException(e);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user", client);
        }


        return clientTable;
    }
}
