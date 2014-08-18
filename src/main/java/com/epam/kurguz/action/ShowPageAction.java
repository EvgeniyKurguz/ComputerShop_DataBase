package com.epam.kurguz.action;

import javax.servlet.http.HttpServletRequest;

public class ShowPageAction implements Action {
    private ActionResult actionResult;

    @Override
    public ActionResult execute(HttpServletRequest request) {
        return actionResult;
    }

    public ShowPageAction(String page) {
        actionResult = new ActionResult();
    }
}
