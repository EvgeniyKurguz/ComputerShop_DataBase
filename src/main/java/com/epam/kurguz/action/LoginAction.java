package com.epam.kurguz.action;

import com.epam.kurguz.dao.DaoFactory;
import com.epam.kurguz.dao.DaoManager;
import com.epam.kurguz.dao.UserDao;
import com.epam.kurguz.dao.h2.H2DaoFactory;
import com.epam.kurguz.entity.User;
import com.epam.kurguz.exception.ActionException;
import com.epam.kurguz.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginAction implements Action {
    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";
    private ActionResult home = new ActionResult("home", true);
    private ActionResult login = new ActionResult("login");
    private ActionResult adminHome = new ActionResult("home", true);

    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException {
        String username = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);
        User user = null;
        DaoManager daoManager = null;
        try {
            DaoFactory daoFactory = new H2DaoFactory();
            daoManager = daoFactory.getDaoManager();
            UserDao userDao = daoManager.getUserDao();
            user = userDao.findUserByUsernameAndPassword(username, password);

            if (user == null) {
                request.setAttribute("loginCheckError", "wrong username or password");
                return login;
            }


            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        } catch (Exception e) {
            try {
                daoManager.rollBack();
            } catch (DaoException e1) {
                throw new ActionException(e);
            }
        } finally {
            try {
                daoManager.close();
            } catch (DaoException e) {
                throw new ActionException(e);
            }
        }
        return home;
    }
}

