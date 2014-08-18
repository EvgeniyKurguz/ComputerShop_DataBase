package com.epam.kurguz.action;

import com.epam.kurguz.dao.UserDao;
import com.epam.kurguz.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginAction implements Action {
    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";
    private ActionResult index = new ActionResult("index");
    private ActionResult login = new ActionResult();

    @Override
    public ActionResult execute(HttpServletRequest request) {
        String username = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);

        UserDao userDao = new UserDao();
        User user = userDao.findByCredentials(username, password);

        if (user == null) {
            return login;
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return index;
    }
}
