package app.database.models.employee;

import DataTypes.Employee;
import app.database.BaseMysql;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static app.database.models.employee.EmployeeTableColumns.*;

public class EmployeeDao extends BaseMysql<Employee> {

    public EmployeeDao() {
        super("employee",TABLE_NAME,COLUMN_ID);
    }


    @Override
    protected Set<String> insertColumns() {

        Set<String> insertColumns = new LinkedHashSet<>();
        insertColumns.add(COLUMN_FIRST_NAME);
        insertColumns.add(COLUMN_MIDDLE_NAME);
        insertColumns.add(COLUMN_LAST_NAME);
        insertColumns.add(COLUMN_SEX);
        insertColumns.add(COLUMN_AGE);
        insertColumns.add(COLUMN_PHONE_NUMBER);
        insertColumns.add(COLUMN_EMAIL);
        insertColumns.add(COLUMN_ADDRESS);
        insertColumns.add(COLUMN_SALARY);
        insertColumns.add(COLUMN_JOB_TYPE);
        insertColumns.add(COLUMN_DEPARTMENT_ID);
        insertColumns.add(COLUMN_IMAGE_ADDRESS);
        insertColumns.add(COLUMN_PASSWORD);
        return insertColumns;
    }

    @Override
    protected Employee getEntityFromResultSet(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt(getColumnIndex(COLUMN_ID));

        String fName = resultSet.getString(getColumnIndex(COLUMN_FIRST_NAME));

        String mName = resultSet.getString(getColumnIndex(COLUMN_MIDDLE_NAME));

        String lName = resultSet.getString(getColumnIndex(COLUMN_LAST_NAME));

        String sex = resultSet.getString(getColumnIndex(COLUMN_SEX));

        int age = resultSet.getInt(getColumnIndex(COLUMN_AGE));

        int phone = resultSet.getInt(getColumnIndex(COLUMN_PHONE_NUMBER));

        String email = resultSet.getString(getColumnIndex(COLUMN_EMAIL));

        String address = resultSet.getString(getColumnIndex(COLUMN_ADDRESS));

        Date date = resultSet.getDate(getColumnIndex(COLUMN_HIRED_DATE));

        int salary = resultSet.getInt(getColumnIndex(COLUMN_SALARY));

        String jobType = resultSet.getString(getColumnIndex(COLUMN_JOB_TYPE));

        int departmentId = resultSet.getInt(getColumnIndex(COLUMN_DEPARTMENT_ID));

        if (resultSet.wasNull()) {
            departmentId = -1;
        }

        String imageAddress = resultSet.getString(getColumnIndex(COLUMN_IMAGE_ADDRESS));

        String password = resultSet.getString(getColumnIndex(COLUMN_PASSWORD));

        return new Employee(id, fName, mName, lName, sex, age, phone, email, address, date, salary, jobType,
                departmentId, imageAddress,password);
    }

    @Override
    protected void prepareInsertStatement(PreparedStatement insertPreparedStatement, Employee entity) throws SQLException {

        insertPreparedStatement.setString(1,entity.getFirstName());
        insertPreparedStatement.setString(2, entity.getMiddleName());
        insertPreparedStatement.setString(3, entity.getLastName());
        insertPreparedStatement.setString(4, entity.getSex());
        insertPreparedStatement.setInt(5, entity.getAge());
        insertPreparedStatement.setInt(6, entity.getPhoneNumber());
        insertPreparedStatement.setString(7, entity.getEmail());
        insertPreparedStatement.setString(8, entity.getAddress());
        //insertPreparedStatement.setDate(9,hiredDate);
        insertPreparedStatement.setInt(9, entity.getSalary());
        insertPreparedStatement.setString(10, entity.getJobType());

        if(entity.getDepartmentId() == -1) {
            insertPreparedStatement.setNull(11, Types.NULL);
        } else {
            insertPreparedStatement.setInt(11, entity.getDepartmentId());
        }


        insertPreparedStatement.setString(12, entity.getImageAddress());
        insertPreparedStatement.setString(13,entity.getPassword());

    }

    public Optional<Employee> findByEmail(String email) {
        List<Employee> employees = findByColumn(COLUMN_EMAIL,email);

        if(employees.size() != 1) {
            return Optional.empty();
        }

        Employee employee = employees.get(0);

        return Optional.of(employee);

    }

    public Optional<Employee> findByPassword(String password) {
        List<Employee> employees = findByColumn(COLUMN_PASSWORD,password);

        if(employees.size() != 1) {
            return Optional.empty();
        }

        Employee employee = employees.get(0);

        return Optional.of(employee);

    }
}
