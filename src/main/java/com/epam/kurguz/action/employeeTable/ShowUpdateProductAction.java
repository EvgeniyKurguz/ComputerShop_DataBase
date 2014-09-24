package com.epam.kurguz.action.employeeTable;

import com.epam.kurguz.action.Action;
import com.epam.kurguz.action.ActionResult;
import com.epam.kurguz.dao.DaoFactory;
import com.epam.kurguz.dao.DaoManager;
import com.epam.kurguz.dao.EmployeeDao;
import com.epam.kurguz.dao.h2.H2DaoFactory;
import com.epam.kurguz.entity.Employee;
import com.epam.kurguz.exception.ActionException;
import com.epam.kurguz.exception.DaoException;

import javax.servlet.http.HttpServletRequest;

public class ShowUpdateProductAction implements Action {
    private final static String ID = "id";
    private ActionResult editEmployee = new ActionResult("editEmployee");

    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException {
        String update = request.getParameter(ID);
        int id = Integer.parseInt(update);

        DaoManager daoManager = null;
        try {
            DaoFactory factory = H2DaoFactory.getInstance();
            daoManager = factory.getDaoManager();
            EmployeeDao employeeDao = daoManager.getEmployeeDao();

            Employee employee = employeeDao.findById(id);
            request.setAttribute("employee", employee);
            daoManager.commit();
        } catch (DaoException e) {
            daoManager.rollBack();
            request.setAttribute("ShowEditEmployeetError", "Show Edit employee error");
        } finally {
            daoManager.close();
        }
        return editEmployee;
    }
}

