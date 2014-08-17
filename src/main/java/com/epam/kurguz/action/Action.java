package com.epam.kurguz.action;

import javax.servlet.http.HttpServletRequest;

public interface Action {
    ActionResult execute(HttpServletRequest request);

}
