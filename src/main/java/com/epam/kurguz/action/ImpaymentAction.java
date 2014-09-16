package com.epam.kurguz.action;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Евгений on 17.09.2014.
 */
public class ImpaymentAction implements Action {
    private ActionResult actionResult;

    public ActionResult execute(HttpServletRequest request) {
        ActionResult registration = new ActionResult("impayment");
        return registration;
    }
    public ImpaymentAction(String s) {
        actionResult = new ActionResult(s);
    }


}