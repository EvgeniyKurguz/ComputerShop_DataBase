package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.JDBCDao;
import com.epam.kurguz.exception.DaoException;
import com.epam.kurguz.dao.EmployeeDao;
import com.epam.kurguz.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2EmployeeDao extends JDBCDao implements EmployeeDao {
    private static final String JOIN = " inner join SEPARATION on EMPLOYEES.ID_SEPARATION = SEPARATION.ID" +
            " inner join ROLE on EMPLOYEES.ID_ROLE = ROLE.ID";
    private static final String UPDATE = "UPDATE  EMPLOYEES" +
            " SET FIRSTNAME = ?, LASTNAME = ?, BIRTH = ?, PHONE = ?,  EMAIL= ? " + JOIN + " WHERE ID = ?";
    private static final String UPDATE_LASTNAME = "UPDATE EMPLOYEES SET LASTNAME = ? " + JOIN + " WHERE ID = ?";
    private static final String UPDATE_POST = "UPDATE EMPLOYEES SET POST = ? " + JOIN + " WHERE ID = ?";
    private static final String FIND_EMPLOYEE_BY_USERNAME_AND_PASSWORD = "SELECT * FROM EMPLOYEES " + JOIN +
            " WHERE USERNAME =? and PASSWORD =?";
    private static final String FIND_BY_USERNAME = "SELECT * FROM EMPLOYEES " + JOIN + " WHERE USERNAME=?";
    private static final String DELETE_EMPLOYEE = "DELETE FROM EMPLOYEES WHERE ID= ?";
    private static final String DELETE_BY_LASTNAME = "DELETE FROM EMPLOYEES WHERE LASTNAME=?";
    private static final String FIND_BY_LASTNAME = "SELECT * FROM EMPLOYEES WHERE LASTNAME=?";
    private static final String CREATE_EMPLOYEE = "INSERT INTO  EMPLOYEES VALUES (default, ?, ?, ?, ?, ?, ?," +
            "(select id from role where role = ?), ?, ?, ?)";
    private static final String CREATE_CLIENT = "INSERT INTO  CLIENTS VALUES (default , ?, ?, ?, ?, ?, ?, (select id from role where role = ?), ?," +
            " (select id from role where role = ?)," +
            " ?," +
            " ?)";
    private static final String GET_EMPLOYEES_LIST = "SELECT * FROM EMPLOYEES";
    private static final String FIND_BY_ID = "SELECT * FROM EMPLOYEES WHERE ID=?";
    private static final String ID = "id";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String BIRTH = "birth";
    private static final String PHONE = "phone";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String POST = "post";
    private static final String EMAIL = "email";
    private static final String SEPARATION = "separation";
    H2AbstractDao dao = new H2AbstractDao();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private Connection connection;

    public H2EmployeeDao(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public void insert(Employee employee) throws DaoException, SQLException {
        try {
            preparedStatement = connection.prepareStatement(CREATE_EMPLOYEE);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, String.valueOf(employee.getBirth()));
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getEmail());
            preparedStatement.setString(6, employee.getSeparation());
            preparedStatement.setString(7, employee.getUserName());
            preparedStatement.setString(8, employee.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public Employee findByLastName(String lastName) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(FIND_BY_LASTNAME);
            preparedStatement.setString(1, lastName);
            resultSet = preparedStatement.executeQuery();
            return getEmployeeFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closing(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public Employee findById(int id) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            return getEmployeeFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closing(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public void update(Employee employee) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, String.valueOf(employee.getBirth()));
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public void deleteById(Employee employee) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public void deleteByLastName(Employee employee) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_LASTNAME);
            preparedStatement.setString(1, employee.getLastName());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public List<Employee> getEmployeeList() throws DaoException {
        try {
            List<Employee> employees = new ArrayList<>();
            preparedStatement = connection.prepareStatement(GET_EMPLOYEES_LIST);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employees.add(createEmployee(resultSet));
            }
            return employees;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closing(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public Employee findEmployeeByUsernameAndPassword(String username, String password) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(FIND_EMPLOYEE_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            return getEmployeeFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean employeeLoginIsOccupied(String username) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(FIND_BY_USERNAME);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Employee createEmployee(ResultSet resultSet) throws DaoException {
        try {
            int id = resultSet.getInt(ID);
            String firstName = resultSet.getString(FIRST_NAME);
            String lastName = resultSet.getString(LAST_NAME);
            String birth = resultSet.getString(BIRTH);
            String phone = resultSet.getString(PHONE);
            String username = resultSet.getString(USERNAME);
            String password = resultSet.getString(PASSWORD);
            String email = resultSet.getString(EMAIL);
            String post = resultSet.getString(POST);
            String separation = resultSet.getString(SEPARATION);
            return new Employee.Builder()
                    .id(id)
                    .firstName(firstName)
                    .lastName(lastName)
                    .birth(Date.valueOf(birth))
                    .phone(phone)
                    .username(username)
                    .password(password)
                    .email(email)
                    .separation(separation)
                    .build();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Employee getEmployeeFromResultSet(ResultSet resultSet) throws DaoException {
        Employee employee = null;
        try {
            if (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getInt(ID));
                employee.setFirstName(resultSet.getString(FIRST_NAME));
                employee.setLastName(resultSet.getString(LAST_NAME));
                employee.setBirth(Date.valueOf(resultSet.getString(BIRTH)));
                employee.setPhone(resultSet.getString(PHONE));
                employee.setUserName(resultSet.getString(USERNAME));
                employee.setPassword(resultSet.getString(PASSWORD));
                employee.setEmail(resultSet.getString(EMAIL));
                employee.setSeparation(resultSet.getString(SEPARATION));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return employee;
    }
}
