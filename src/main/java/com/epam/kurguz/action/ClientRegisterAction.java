package com.epam.kurguz.action;


import com.epam.kurguz.dao.ClientDao;
import com.epam.kurguz.dao.DaoManager;
import com.epam.kurguz.dao.h2.H2DaoFactory;
import com.epam.kurguz.entity.Client;
import com.epam.kurguz.exception.ActionException;
import com.epam.kurguz.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class ClientRegisterAction implements Action {
    private static final String FIRSTNAME = "firstName";
    private static final String LASTNAME = "lastName";
    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";
    private final static String CONFIRM_PASSWORD = "confirmPassword";
    private final static String EMAIL = "email";
    private static final String BIRTH = "birth";
    private static final String CITY = "city";
    private static final String COUNTRY = "country";
    private static final String PHONE = "phone";

    Validator validator = new Validator();
    private ActionResult home = new ActionResult("home", true);
    private ActionResult register = new ActionResult("clientRegistration");

    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException {
        String firstName = request.getParameter(FIRSTNAME);
        String lastName = request.getParameter(LASTNAME);
        String username = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);
        String confirmPassword = request.getParameter(CONFIRM_PASSWORD);
        String birth = request.getParameter(BIRTH);
        String email = request.getParameter(EMAIL);
        String city = request.getParameter(CITY);
        String country = request.getParameter(COUNTRY);
        String phone = request.getParameter(PHONE);

        H2DaoFactory factory;
        ClientDao clientDao = null;
        try {
            factory = new H2DaoFactory();
            DaoManager daoManager = factory.getDaoManager();
            clientDao = daoManager.getClientDao();
        } catch (DaoException e) {
            throw new ActionException(e);
        }

        try {
            boolean isOccupied = clientDao.clientLoginIsOccupied(username);
            if (isOccupied) {
                request.setAttribute("loginError", "This login is not available");
                return register;
            }
        } catch (DaoException e) {
            throw new ActionException(e);
        }

        if (!password.equals(confirmPassword)) {
            request.setAttribute("passwordError", "The entered passwords do not match");
            return register;
        }

        if (!(validator.usernameValidation(username))) {
            request.setAttribute("loginRegexError", "Login entered incorrectly");
            return register;
        }

        if (!(validator.passwordValidation(password))) {
            request.setAttribute("passwordRegexError", "The password is not suitable");
            return register;
        }

        if (!(validator.emailValidation(email))) {
            request.setAttribute("emailRegexError", "Email entered incorrectly");
            return register;
        }

        if (!(validator.dateValidation(birth))) {
            request.setAttribute("birthRegexError", "Date of birth entered incorrectly");
            return register;
        }

        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setUserName(username);
        client.setPassword(password);
        client.setPhone(phone);
        client.setEmail(email);
        client.setBirth(Date.valueOf(birth));

        client.setCity(city);
        client.setCountry(country);
        try {
            clientDao.insert(client);
        } catch (DaoException e) {
            throw new ActionException(e);
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", client);
        session.setAttribute("registrationGood", "Congratulations, you have successfully registered!");
        return home;
    }
}
