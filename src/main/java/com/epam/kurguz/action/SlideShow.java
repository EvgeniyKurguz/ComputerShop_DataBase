package com.epam.kurguz.action;


import javax.servlet.http.HttpServletRequest;

public class SlideShow implements Action {
    private ActionResult actionResult;

    public ActionResult execute(HttpServletRequest request) {
        ActionResult registration = new ActionResult("imagebrowser");
        return registration;
    }
    public SlideShow(String s) {
        actionResult = new ActionResult(s);
    }


}