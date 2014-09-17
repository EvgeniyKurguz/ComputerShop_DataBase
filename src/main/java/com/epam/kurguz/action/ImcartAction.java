package com.epam.kurguz.action;

import javax.servlet.http.HttpServletRequest;

public class ImcartAction implements Action {
    private ActionResult actionResult;

    public ActionResult execute(HttpServletRequest request) {
        ActionResult actionResult = new ActionResult("imcart");
        return actionResult;
    }
    public ImcartAction(String s) {
        actionResult = new ActionResult(s);
    }


}