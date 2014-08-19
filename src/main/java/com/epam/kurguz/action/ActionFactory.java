package com.epam.kurguz.action;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    //    private static Logger logger = LoggerFactory.getLogger(ActionFactory.class);
    static Map<String, Action> actionMap = new HashMap<>();

    static {
        ShowLoginPageAction showLoginPageAction = new ShowLoginPageAction();
        actionMap.put("GET/", showLoginPageAction);
        actionMap.put("POST/", new LoginAction());
        actionMap.put("GET/index", new ShowPageAction("index"));
        actionMap.put("GET/registration", new FormRegistrationAction(""));
        actionMap.put("GET/login",  new ExitAction(""));
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