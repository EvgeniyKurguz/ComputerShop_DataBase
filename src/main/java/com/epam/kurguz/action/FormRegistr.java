package com.epam.kurguz.action;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class FormRegistr extends FormRegistrationAction {
    private static Logger logger = (Logger) LoggerFactory.getLogger(FormRegistr.class);
    static Map<String, Action> actionMap = new HashMap<String, Action>();

     {
        actionMap.put("registration", (Action) new FormRegistrationAction());
    }

    public static Action getAction(String actionName) {
        return actionMap.get(actionName);
    }
}

