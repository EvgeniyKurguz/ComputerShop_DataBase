package com.epam.kurguz.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private static Logger logger = LoggerFactory.getLogger(ActionFactory.class);
    static Map<String, Action> actionMap = new HashMap<String, Action>();

    static {


    }

    public static Action getAction(String actionName) {
        return actionMap.get(actionName);
    }

    public static void getAllAction() {
        for (String s : actionMap.keySet()) {
            System.out.println(s);
        }
    }
}
