package com.epam.kurguz.action;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
      static Map<String, Action> actionMap = new HashMap<>();

    static {
        ShowLoginPageAction showLoginPageAction = new ShowLoginPageAction();
        actionMap.put("GET/", showLoginPageAction);
        actionMap.put("POST/", new LoginAction());
        actionMap.put("GET/index", new ShowPageAction("index"));
        actionMap.put("GET/registration", new FormRegistrationAction("registration"));
        actionMap.put("GET/login",  new ExitAction("login"));

    }

    public static Action getAction(String actionName) {
        return actionMap.get(actionName);
    }
}

