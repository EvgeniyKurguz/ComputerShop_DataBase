package com.epam.kurguz.action;

import javax.servlet.http.HttpServletRequest;

public class FormRegistrationAction implements Action {

  public ActionResult execute(HttpServletRequest request) {
       ActionResult registration = new ActionResult("registration");

        return registration;
    }
}
