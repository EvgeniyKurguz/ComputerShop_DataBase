package com.epam.kurguz.action;

import com.epam.kurguz.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class ShowLoginPageAction implements Action {
    public static final String USER = "user";
    private ActionResult login = new ActionResult();
    private ActionResult index = new ActionResult("index", true);

    @Override
    public ActionResult execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        if (user != null) return index;
        return login;
    }
}
