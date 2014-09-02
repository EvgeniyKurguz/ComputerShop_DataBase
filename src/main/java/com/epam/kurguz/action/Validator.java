package com.epam.kurguz.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String USERNAME_REGEX = "^[A-Za-z]([\\.A-Za-z0-9-]{1,18})([A-Za-z0-9])$";
    private static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-zA-Z])(?!.*\\s).{8,20}$";
    private static final String EMAIL_REGEX = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    private static final String DATE_REGEX = "^(19|20)\\d\\d[\\-](0[1-9]|1[012])[\\-](0[1-9]|[12][0-9]|3[01])$";
    Matcher matcher;
    Pattern pattern;

    public boolean passwordValidation(String password) {
        pattern = Pattern.compile(PASSWORD_REGEX);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public boolean usernameValidation(String username) {
        pattern = Pattern.compile(USERNAME_REGEX);
        matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public boolean emailValidation(String email) {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean dateValidation(String date) {
        pattern = Pattern.compile(DATE_REGEX);
        matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
