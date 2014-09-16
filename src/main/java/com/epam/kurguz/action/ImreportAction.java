package com.epam.kurguz.action;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Евгений on 17.09.2014.
 */
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


