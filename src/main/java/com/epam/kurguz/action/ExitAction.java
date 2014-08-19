package com.epam.kurguz.action;

import javax.servlet.http.HttpServletRequest;

public class ExitAction implements Action {
    private ActionResult actionResult;

    public ActionResult execute(HttpServletRequest request) {
        ActionResult login = new ActionResult("login");
        return login;
    }

    public ExitAction(String s) {
        actionResult = new ActionResult(s);
    }


}


