package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.DaoHelper;
import com.epam.kurguz.dao.EmployeeDao;
import com.epam.kurguz.dao.JDBCDao;
import com.epam.kurguz.entity.Employee;
import com.epam.kurguz.entity.User;
import com.epam.kurguz.exception.DaoException;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2EmployeeDao extends JDBCDao<Employee> implements EmployeeDao {

    private static final String JOIN = " inner join SEPARATION on employee.separation_id = SEPARATION.ID" +
            " inner join ROLE on employee.role_id = ROLE.ID";
    private static final String UPDATE_LASTNAME = "UPDATE employee SET LASTNAME = ? " + JOIN + " WHERE ID = ?";
    private static final String UPDATE_POST = "UPDATE employee SET POST = ? " + JOIN + " WHERE ID = ?";
    private static final String UPDATE_BY_ACCOUNT = "UPDATE employee SET ACCOUNT=? " + JOIN + " WHERE .employee.ID=?";
    private static final String FIND_EMPLOYEE_BY_USERNAME_AND_PASSWORD = "SELECT * FROM employee " + JOIN +
            " WHERE USERNAME =? and PASSWORD =?";
    private static final String FIND_BY_USERNAME = "SELECT * FROM employee " + JOIN + " WHERE USERNAME=?";
    private static final String FIND_BY_ID = "SELECT * FROM employee " + JOIN + " WHERE employee.ID=?";
    private static final String FIND_RANGE = "SELECT * FROM employee " + JOIN + "" +
            " where not is_blocked ORDER BY ID LIMIT ? OFFSET ?";
    private static final String UPDATE = "UPDATE  employee" +
            " SET FIRSTNAME = ?, LASTNAME = ?, BIRTH = ?, PHONE = ?, ATTESTATION_NUMBER= ?, EMAIL= ?," +
            "role_id=(select id from ROLE where ROLE = ?),separation_id=(select id from SEPARATION where SEPARATION = ?)," +
            "USERNAME=?,PASSWORD=?,ACCOUNT=? WHERE ID = ?";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE ID= ?";
    private static final String DELETE_BY_LASTNAME = "DELETE FROM employee WHERE LASTNAME=?";
    private static final String FIND_BY_LASTNAME = "SELECT * FROM employee WHERE LASTNAME=?";
    private static final String CREATE_EMPLOYEE = "INSERT INTO  employee VALUES (default, ?, ?, ?, ?, ?, ?," +
            "(select id from role where role = ?), ?, ?, ?)";
    private static final String GET_EMPLOYEE_LIST = "SELECT * FROM employee";
    private static final String GET_RECORDS_COUNT = "SELECT COUNT(*) FROM employee";
    private static final String ID = "id";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String BIRTH = "birth";
    private static final String PHONE = "phone";
    private static final String ATTESTATION_NUMBER = "attestation_Number";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String ROLE = "role";
    private static final String EMAIL = "email";
    private static final String SEPARATION = "separation";
    private static final String ACCOUNT = "account";

    public H2EmployeeDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectRequest() throws DaoException {
        return null;
    }

    @Override
    public String getSelectCount() throws DaoException {
        return null;
    }

    @Override
    public String getSelectRequestByRange() throws DaoException {
        return null;
    }

    @Override
    public void insert(Employee employee) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_EMPLOYEE)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, String.valueOf(employee.getBirth()));
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getAttestationNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, String.valueOf(employee.getRole()));
            preparedStatement.setString(8, employee.getSeparation());
            preparedStatement.setString(9, employee.getUsername());
            preparedStatement.setString(10, employee.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Employee findByLastName(String lastName) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_LASTNAME)) {
            preparedStatement.setString(1, lastName);
            resultSet = preparedStatement.executeQuery();
            return getFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public Employee findById(int id) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            return getFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public void update(Employee employee) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, String.valueOf(employee.getBirth()));
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getAttestationNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, String.valueOf(employee.getRole()));
            preparedStatement.setString(8, employee.getSeparation());
            preparedStatement.setString(9, employee.getUsername());
            preparedStatement.setString(10, employee.getPassword());
            preparedStatement.setBigDecimal(11, employee.getAccount());
            preparedStatement.setInt(12, employee.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteById(Employee employee) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE)) {
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteByLastName(Employee employee) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_LASTNAME)) {
            preparedStatement.setString(1, employee.getLastName());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Employee> getEmployeeList() throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_EMPLOYEE_LIST)) {
            List<Employee> employees = new ArrayList<>();
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employees.add(createEntity(resultSet));
            }
            return employees;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public Employee findEmployeeByUsernameAndPassword(String username, String password) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_EMPLOYEE_BY_USERNAME_AND_PASSWORD)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            return getFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public boolean employeeLoginIsOccupied(String username) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public Employee createEntity(ResultSet resultSet) throws DaoException {
        try {
            int id = resultSet.getInt(ID);
            String firstName = resultSet.getString(FIRST_NAME);
            String lastName = resultSet.getString(LAST_NAME);
            String birth = resultSet.getString(BIRTH);
            String phone = resultSet.getString(PHONE);
            String attestationNumber = resultSet.getString(ATTESTATION_NUMBER);
            String username = resultSet.getString(USERNAME);
            String password = resultSet.getString(PASSWORD);
            String email = resultSet.getString(EMAIL);
            User.Role role = User.Role.valueOf(resultSet.getString(ROLE));
            BigDecimal account = new BigDecimal(resultSet.getString(ACCOUNT));
            String separation = resultSet.getString(SEPARATION);
            return new Employee.Builder()
                    .id(id)
                    .firstName(firstName)
                    .lastName(lastName)
                    .birth(Date.valueOf(birth))
                    .phone(phone)
                    .attestationNumber(attestationNumber)
                    .username(username)
                    .password(password)
                    .email(email)
                    .account(account)
                    .role(role)
                    .separation(separation)
                    .build();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Employee getFromResultSet(ResultSet resultSet) throws DaoException {
        Employee employee = null;
        try {
            if (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getInt(ID));
                employee.setFirstName(resultSet.getString(FIRST_NAME));
                employee.setLastName(resultSet.getString(LAST_NAME));
                employee.setBirth(Date.valueOf(resultSet.getString(BIRTH)));
                employee.setPhone(resultSet.getString(PHONE));
                employee.setAttestationNumber(resultSet.getString(ATTESTATION_NUMBER));
                employee.setUsername(resultSet.getString(USERNAME));
                employee.setPassword(resultSet.getString(PASSWORD));
                employee.setEmail(resultSet.getString(EMAIL));
                employee.setRole(User.Role.valueOf(resultSet.getString(ROLE)));
                employee.setSeparation(resultSet.getString(SEPARATION));
                employee.setAccount(resultSet.getBigDecimal(ACCOUNT));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return employee;
    }
}
