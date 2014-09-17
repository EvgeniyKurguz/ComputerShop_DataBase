package com.epam.kurguz.action;

import javax.servlet.http.HttpServletRequest;

public class ImreportAction implements Action {
    private ActionResult actionResult;

    public ActionResult execute(HttpServletRequest request) {
        ActionResult registration = new ActionResult("imreport");
        return registration;
    }
    public ImreportAction(String s) {
        actionResult = new ActionResult(s);
    }


}


