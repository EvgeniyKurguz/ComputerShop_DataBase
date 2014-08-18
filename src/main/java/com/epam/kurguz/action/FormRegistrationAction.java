package com.epam.kurguz.action;

import javax.servlet.http.HttpServletRequest;

public class FormRegistrationAction implements Action {
    private ActionResult actionResult;

    public ActionResult execute(HttpServletRequest request) {
        ActionResult registration = new ActionResult("registration");
        return registration;
    }
        public FormRegistrationAction(String s) {
            actionResult = new ActionResult(s);
        }


    }

