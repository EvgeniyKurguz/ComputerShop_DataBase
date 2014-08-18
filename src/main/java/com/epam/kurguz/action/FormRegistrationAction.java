package com.epam.kurguz.action;

import javax.servlet.http.HttpServletRequest;

public class FormRegistrationAction  {

    public  String execute(HttpServletRequest request) {
        return "../WEB-INF/registration.jsp";
    }
}
