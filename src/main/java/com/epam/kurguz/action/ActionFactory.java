package com.epam.kurguz.action;


import com.epam.kurguz.action.table.*;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
      static Map<String, Action> actionMap = new HashMap<String, Action>();

    static {
        ShowLoginPageAction showLoginPageAction = new ShowLoginPageAction();
        actionMap.put("GET/", showLoginPageAction);
        actionMap.put("POST/", new LoginAction());

        actionMap.put("GET/index", new ShowPageAction("index"));
        actionMap.put("GET/registration", new FormRegistrationAction("registration"));
        actionMap.put("GET/login", new ShowLoginPageAction());
        actionMap.put("POST/login", new LoginAction());


        actionMap.put("GET/fullscreen",  new FullscreenAction("fullscreen"));
        actionMap.put("GET/imagebrowser",  new ProductAction("imagebrowser"));
        actionMap.put("GET/laptop",  new ProductAction("laptop"));

        actionMap.put("GET/clientTable", new ShowClientTableAction());
        actionMap.put("POST/clientTable", new DeleteClientAction());
        actionMap.put("GET/clientRegistration", new ShowPageAction("clientRegistration"));
        actionMap.put("POST/clientRegistration", new ClientRegisterAction());
        actionMap.put("GET/createClient", new ShowPageAction("createClient"));
        actionMap.put("POST/createClient", new CreateClientAction());

        actionMap.put("GET/updateClient", new ShowPageAction("updateClient"));
        actionMap.put("POST/updateClient", new UpdateClientAction());

        actionMap.put("GET/productTable", new ProductTableAction());
        actionMap.put("GET/createProduct", new ShowPageAction("createProduct"));
        actionMap.put("POST/createProduct", new CreateClientAction());

        actionMap.put("GET/imcart",  new ImcartAction("imcart"));
        actionMap.put("GET/imform",  new ImformAction("imform"));
        actionMap.put("GET/imreport",  new ImreportAction("imreport"));
        actionMap.put("GET/impayment",  new ImpaymentAction("impayment"));
    }

    public static Action getAction(String actionName) {
        return actionMap.get(actionName);
    }
}

