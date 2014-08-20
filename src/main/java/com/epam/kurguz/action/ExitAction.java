package com.epam.kurguz.action;

import javax.servlet.http.HttpServletRequest;

public class ExitAction implements Action {
    private ActionResult actionResult;

    public ActionResult execute(HttpServletRequest request) {
        ActionResult actionResult = new ActionResult("login");
        return actionResult;
    }

    public ExitAction(String s) {
        actionResult = new ActionResult(s);
    }

}


