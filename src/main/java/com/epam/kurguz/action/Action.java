package com.epam.kurguz.action;

import com.epam.kurguz.exception.ActionException;

import javax.servlet.http.HttpServletRequest;

public interface Action {
    ActionResult execute(HttpServletRequest request) throws ActionException;

}
