package com.epam.kurguz.action;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private final static Map<String, Action> actions = new HashMap<String, Action>();

    static {
    }

    public static Action getAction(String actionName) {
        return actions.get(actionName);
    }
}
