package com.epam.kurguz.action;


import com.epam.kurguz.dao.DaoFactory;
import com.epam.kurguz.dao.DaoManager;
import com.epam.kurguz.dao.EmployeeDao;
import com.epam.kurguz.dao.h2.H2DaoFactory;
import com.epam.kurguz.entity.Employee;
import com.epam.kurguz.entity.User;
import com.epam.kurguz.exception.ActionException;
import com.epam.kurguz.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class EmployeeRegisterAction implements Action {
    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";
    private final static String CONFIRM_PASSWORD = "confirmPassword";
    private final static String ROLE = "role";
    private static final String EMAIL = "email";
    private static final String BIRTH = "birth";
    private static final String SEPARATION = "separation";
    private static Logger logger = LoggerFactory.getLogger(ClientRegisterAction.class);
    Validator validator = new Validator();
    private ActionResult home = new ActionResult("home", true);
    private ActionResult register = new ActionResult("employeeRegistration");

    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException {
        String username = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);
        String confirmPassword = request.getParameter(CONFIRM_PASSWORD);
        String email = request.getParameter(EMAIL);
        String role = request.getParameter(ROLE);
        String birth = request.getParameter(BIRTH);
        String separation = request.getParameter(SEPARATION);

        DaoManager daoManager = null;
        try {
            DaoFactory factory = H2DaoFactory.getInstance();
            daoManager = factory.getDaoManager();
            EmployeeDao employeeDao = daoManager.getEmployeeDao();

            boolean isOccupied = employeeDao.employeeLoginIsOccupied(username);
            if (isOccupied) {
                request.setAttribute("loginError", "This login is not available");
                return register;
            }


            if (!password.equals(confirmPassword)) {
                request.setAttribute("passwordError", "The entered passwords do not match");
                return register;
            }

            if (!(validator.usernameValidation(username))) {
                request.setAttribute("loginRegexError", "Login entered incorrectly");
                return register;
            }

            if (!(validator.passwordValidation(password))) {
                request.setAttribute("passwordRegexError", "The password is not suitable");
                return register;
            }

            if (!(validator.emailValidation(email))) {
                request.setAttribute("emailRegexError", "Email entered incorrectly");
                return register;
            }

            if (!(validator.dateValidation(birth))) {
                request.setAttribute("birthRegexError", "Date of birth entered incorrectly");
                return register;
            }

            Employee employee = new Employee();
            employee.setUsername(username);
            employee.setPassword(password);
            employee.setEmail(email);
            employee.setBirth(Date.valueOf(birth));
            employee.setRole(User.Role.valueOf(role));
            employee.setSeparation(separation);
            employeeDao.insert(employee);

            HttpSession session = request.getSession();
            session.setAttribute("user", employee);
            session.setAttribute("registrationGood", "Congratulations, you have successfully registered!");
            daoManager.commit();
        } catch (DaoException e) {
            daoManager.rollBack();
            request.setAttribute("DeleteClientError", "Delete client error");
        } finally {
            daoManager.close();
        }
        return home;
    }
}



