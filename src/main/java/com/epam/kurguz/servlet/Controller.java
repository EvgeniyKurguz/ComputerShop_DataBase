package com.epam.kurguz.servlet;

import com.epam.kurguz.action.Action;
import com.epam.kurguz.action.ActionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String actionName = req.getParameter("action");
        Action action = ActionFactory.getAction(actionName);
        String result = action.execute(req);
        req.getRequestDispatcher(result).forward(req, resp);
    }
}

