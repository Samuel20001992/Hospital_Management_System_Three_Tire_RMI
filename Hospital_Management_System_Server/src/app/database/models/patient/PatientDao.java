package app.database.models.patient;


import DataTypes.Patient;
import app.database.BaseMysql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import static app.database.models.patient.PatientTableColumns.*;

public class PatientDao extends BaseMysql<Patient> {

    public PatientDao() {
        super("patient", TABLE_NAME, COLUMN_ID);
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
        insertColumns.add(COLUMN_ADDRESS);

        return insertColumns;
    }

    @Override
    protected Patient getEntityFromResultSet(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt(
                getColumnIndex(COLUMN_ID)
        );
        String fName = resultSet.getString(
                getColumnIndex(COLUMN_FIRST_NAME)
        );
        String mName = resultSet.getString(
                getColumnIndex(COLUMN_MIDDLE_NAME)
        );
        String lName = resultSet.getString(
                getColumnIndex(COLUMN_LAST_NAME)
        );
        String sex = resultSet.getString(
                getColumnIndex(COLUMN_SEX)
        );
        int age = resultSet.getInt(
                getColumnIndex(COLUMN_AGE)
        );
        int phone = resultSet.getInt(
                getColumnIndex(COLUMN_PHONE_NUMBER)
        );

        String address = resultSet.getString(
                getColumnIndex(COLUMN_ADDRESS)
        );

        Date regDate = resultSet.getDate(
                getColumnIndex(COLUMN_REGISTRATION_DATE
                )
        );

        return new Patient(
                id,
                fName,
                mName,
                lName,
                sex,
                age,
                phone,
                address,
                regDate
        );
    }


    @Override
    protected void prepareInsertStatement(PreparedStatement preparedStatement, Patient entity) throws SQLException {
        preparedStatement.setString(1,entity.getFirstName());
        preparedStatement.setString(2,entity.getMiddleName());
        preparedStatement.setString(3,entity.getLastName());
        preparedStatement.setString(4,entity.getSex());
        preparedStatement.setInt(5,entity.getAge());
        preparedStatement.setInt(6,entity.getPhoneNumber());
        preparedStatement.setString(7,entity.getAddress());
    }
}
