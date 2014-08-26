package com.epam.kurguz.dao.h2;

import com.epam.kurguz.dao.DaoException;
import com.epam.kurguz.dao.EmployeeDao;
import com.epam.kurguz.entity.Employee;
import com.epam.kurguz.pool.PoolException;
import com.jolbox.bonecp.BoneCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class H2EmployeeDao implements EmployeeDao {
    private static final String CREATE_EMPLOYEE = "INSERT INTO  EMPLOYEES VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_EMPLOYEE = "DELETE FROM EMPLOYEES WHERE ID= ?";
    private static final String FIND_BY_ID = "SELECT * FROM EMPLOYEES WHERE ID=?";
    private static final String FIND_BY_LASTNAME = "SELECT * FROM EMPLOYEES WHERE LASTNAME=?";
    private static final String DELETE_BY_LASTNAME = "DELETE FROM EMPLOYEES WHERE LASTNAME=?";
    private static final String UPDATE = "UPDATE  EMPLOYEES" +
            " SET FIRSTNAME = ?, LASTNAME = ?, BIRTH = ?, PHONE = ?, , EMAIL= ? WHERE ID = ?";
    private static final String UPDATE_LASTNAME = "UPDATE EMPLOYEES SET LASTNAME = ? WHERE ID = ?";
    private static final String UPDATE_POST = "UPDATE EMPLOYEES SET POST = ? WHERE ID = ?";
    private static final String GET_EMPLOYEES_LIST = "SELECT * FROM EMPLOYEES";
    private static final String GET_BY_POST = "SELECT * FROM EMPLOYEES WHERE POST=?";
    private static final BoneCP pool;
    private static final String ID = "id";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String BIRTH = "birth";
    private static final String PHONE = "phone";

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String POST = "post";


    static {
        BoneCP tmp = null;
        try {
            tmp = H2DaoFactory.getH2ConnectionPool();
        } catch (PoolException e) {
            //add
        }
        pool = tmp;
    }

    H2AbstractDao dao = new H2AbstractDao();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public Employee getByPost(String post) throws DaoException {
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(GET_BY_POST);
            preparedStatement.setString(1, post);
            resultSet = preparedStatement.executeQuery();
            return getEmployeeFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closing(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public Employee getByLastName(String lastName) throws DaoException {
        try {
            connection = pool.getConnection();
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
    public void insert(Employee employee) throws DaoException {
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_EMPLOYEE);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getBirth());
            preparedStatement.setString(4, employee.getPhone());

            preparedStatement.setString(6, employee.getPost());
            preparedStatement.setInt(7, employee.getId());
            preparedStatement.setString(8, employee.getUserName());
            preparedStatement.setString(9, employee.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public void insert(Object entityToCreate) throws DaoException, SQLException {

    }

    @Override
    public Employee getById(int id) throws DaoException {
        try {
            connection = pool.getConnection();
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
    public void update(Object entityToUpdate) throws DaoException, SQLException {

    }

    @Override
    public void delete(Object entityToCreate) throws DaoException, SQLException {

    }

    @Override
    public void update(Employee employee) throws DaoException, SQLException {
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getBirth());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getPost());
            preparedStatement.setString(6, employee.getPost());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public void delete(int id) throws DaoException, SQLException {

    }

    @Override
    public void deleteById(int id) throws DaoException, SQLException {
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closingPreparedStatAndConn(preparedStatement, connection);
        }
    }

    @Override
    public void deleteByLastName(String lastName) throws DaoException {
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_BY_LASTNAME);
            preparedStatement.setString(1, lastName);
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
            connection = pool.getConnection();
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
        String sql = "SELECT *" +
                "FROM EMPLOYEES " +
                "where USERNAME = " + "'" + username + "'" + "and PASSWORD = " + "'" + password + "'";
        try {
            connection = pool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            return getEmployeeFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dao.closing(resultSet, preparedStatement, connection);
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

            String post = resultSet.getString(POST);
            return new Employee.Builder()
                    .id(id)
                    .firstName(firstName)
                    .lastName(lastName)
                    .birth(birth)
                    .phone(phone)

                    .username(username)
                    .password(password)

                    .post(post)
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
                employee.setBirth(resultSet.getString(BIRTH));
                employee.setPhone(resultSet.getString(PHONE));

                employee.setUserName(resultSet.getString(USERNAME));
                employee.setPassword(resultSet.getString(PASSWORD));


            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return employee;
    }
}
