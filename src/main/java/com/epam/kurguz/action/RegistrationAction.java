package com.epam.kurguz.action;

import com.epam.kurguz.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class RegistrationAction implements Action {
    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";
    private  int id;
    private  String firstName;
    private  String lastName;
    private  String username;
    private  String phone;
    private Date birth;
    private final static String EMAIL = "email";


    @Override
    public ActionResult execute(HttpServletRequest request) {
        String login = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);
        String email = request.getParameter("email");


        User user = new User(id, firstName, lastName, birth, phone, username, password, email);

        request.setAttribute("user", user);
        return null;
    }
}
