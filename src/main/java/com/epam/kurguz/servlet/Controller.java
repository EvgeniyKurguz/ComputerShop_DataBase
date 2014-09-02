package com.epam.kurguz.servlet;

import com.epam.kurguz.action.Action;
import com.epam.kurguz.action.ActionFactory;
import com.epam.kurguz.action.ActionResult;
import com.epam.kurguz.exception.ActionException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getPathInfo().contains("static")) {
            return;
        }
        String actionName = req.getMethod() + req.getPathInfo();

        Action action = ActionFactory.getAction(actionName);
        if (action == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "url.not.found");
            return;
        }

        ActionResult result = null;
        try {
            result = action.execute(req);
        } catch (ActionException e) {
            e.printStackTrace();
        }

        if (result.isRedirection()) {
            resp.sendRedirect(req.getContextPath() + "/" + result.getView());
            return;
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/" + result.getView() + ".jsp");
        requestDispatcher.forward(req, resp);
    }
}

