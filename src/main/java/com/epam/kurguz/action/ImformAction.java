package com.epam.kurguz.action;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Евгений on 16.09.2014.
 */
public class ImformAction implements Action {

    private ActionResult actionResult;

    public ActionResult execute(HttpServletRequest request) {
        ActionResult registration = new ActionResult("imform");
        return registration;
    }
    public ImformAction(String s) {
        actionResult = new ActionResult(s);
    }


}

