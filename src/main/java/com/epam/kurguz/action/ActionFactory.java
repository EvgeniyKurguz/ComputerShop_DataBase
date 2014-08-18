package com.epam.kurguz.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private static Logger logger = LoggerFactory.getLogger(ActionFactory.class);
    static Map<String, Action> actionMap = new HashMap<String, Action>();

    static {
        ShowLoginPageAction showLoginPageAction = new ShowLoginPageAction();
        actionMap.put("GET/", showLoginPageAction);
        actionMap.put("POST/", new LoginAction());
        actionMap.put("GET/index", new ShowPageAction("index"));
        actionMap.put("GET/registration",  new FormRegistrationAction());
           }

    public static Action getAction(String actionName) {
        return actionMap.get(actionName);
    }
}

//{
//    private static Logger logger = LoggerFactory.getLogger(ActionFactory.class);
//    static Map<String, Action> actionMap = new HashMap<String, Action>();
//
//    static {
//        actionMap.put("registrationAction", new ParseAction());
//    }
//
//    public static Action getAction(String actionName) {
//        return actionMap.get(actionName);
//    }
//}