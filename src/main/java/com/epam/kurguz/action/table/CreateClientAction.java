package com.epam.kurguz.action.table;

import com.epam.kurguz.action.Action;
import com.epam.kurguz.action.ActionResult;
import com.epam.kurguz.action.Validator;
import com.epam.kurguz.dao.ClientDao;
import com.epam.kurguz.dao.DaoManager;
import com.epam.kurguz.dao.h2.H2DaoFactory;
import com.epam.kurguz.entity.Client;
import com.epam.kurguz.exception.ActionException;
import com.epam.kurguz.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class CreateClientAction implements Action {
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
    Validator validator;
    ActionResult clientTable = new ActionResult("clientTable", true);
    ActionResult createClient = new ActionResult("createClient");

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

        if (!(validator.usernameValidation(username))) {
            request.setAttribute("loginRegexError", "Login entered incorrectly");
            return createClient;
        }

        if (!(validator.passwordValidation(password))) {
            request.setAttribute("passwordRegexError", "The password is not suitable");
            return createClient;
        }

        if (!(validator.emailValidation(email))) {
            request.setAttribute("emailRegexError", "Email entered incorrectly");
            return createClient;
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
        try {
            clientDao.insert(client);
        } catch (DaoException e) {
            throw new ActionException(e);
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", client);
        return clientTable;
    }
}
