package com.epam.kurguz.action.orderTable;

import com.epam.kurguz.action.Action;
import com.epam.kurguz.action.ActionResult;
import com.epam.kurguz.exception.ActionException;

import javax.servlet.http.HttpServletRequest;

public class OrderTableAction implements Action {
    ActionResult  orderTable = new ActionResult("orderTable");

    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException {
        return orderTable;
    }
}
