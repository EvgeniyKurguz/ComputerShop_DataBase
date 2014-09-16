package com.epam.kurguz.action.table;

import com.epam.kurguz.action.ActionResult;
import com.epam.kurguz.action.Validator;

/**
 * Created by Евгений on 16.09.2014.
 */
public class CreatProductAction {
    private static final String FIRSTNAME = "firstName";
    private static final String LASTNAME = "lastName";
    private static final String BIRTH = "birth";
    private static final String PHONE = "phone";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";
    private static final String CITY = "city";
    private static final String COUNTRY = "country";
    Validator validator;
    ActionResult clientTable = new ActionResult("clientTable", true);
    ActionResult createClient = new ActionResult("createClient");
}
