package com.epam.kurguz.action;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Евгений on 28.08.2014.
 */
public class ProductAction implements Action {
    private ActionResult actionResult;

    public ActionResult execute(HttpServletRequest request) {
        ActionResult registration = new ActionResult("laptop");
        return registration;
    }
    public ProductAction(String s) {
        actionResult = new ActionResult(s);
    }


}