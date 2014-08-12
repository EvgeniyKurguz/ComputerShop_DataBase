package com.epam.kurguz.action;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ActionFactory {
    private static Logger logger = LoggerFactory.getLogger(ActionFactory.class);
    static Map<String, Action> actionMap = new HashMap<String, Action>();

    static {
        Reflections reflections = new Reflections(ActionFactory.class.getPackage().getName());
        Set<Class<? extends Action>> actions = reflections.getSubTypesOf(Action.class);
        for (Class<? extends Action> action : actions) {
            try {
                actionMap.put(action.getSimpleName().toLowerCase(), action.newInstance());
            } catch (InstantiationException e) {
                logger.error(e.toString());
            } catch (IllegalAccessException e) {
                logger.error(e.toString());
            }
        }
    }

    public static Action getAction(String actionName) {
        return actionMap.get(actionName);
    }

    public static void getAllAction (){
        for (String s : actionMap.keySet()) {
            System.out.println(s);
        }
    }
}
