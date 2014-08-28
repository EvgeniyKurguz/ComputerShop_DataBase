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
        actionMap.put("GET/fullscreen",  new FullscreenAction("fullscreen"));
        actionMap.put("GET/imagebrowser",  new ProductAction("imagebrowser"));
        actionMap.put("GET/laptop",  new ProductAction("laptop"));
    }

    public static Action getAction(String actionName) {
        return actionMap.get(actionName);
    }
}

