package app.database.models.appointment;

import DataTypes.Appointment;
import app.database.BaseMysql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import static app.database.models.appointment.AppointmentTableColumns.*;

public class AppointmentDao extends BaseMysql<Appointment> {

    public AppointmentDao() {
        super("appointment", TABLE_NAME, COLUMN_ID);
    }


    @Override
    protected Set<String> insertColumns() {

        Set<String> insertColumns = new LinkedHashSet<>();
        insertColumns.add(COLUMN_PATIENT_ID);
        insertColumns.add(COLUMN_DOCTOR_ID);
        insertColumns.add(COLUMN_DESCRIPTION);
        insertColumns.add(COLUMN_DATE);


        return insertColumns;

    }

    @Override
    protected Appointment getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COLUMN_ID);

        int patientId = resultSet.getInt(COLUMN_PATIENT_ID);
        int doctorId = resultSet.getInt(COLUMN_DOCTOR_ID);

        String description = resultSet.getString(COLUMN_DESCRIPTION);
        Date date = resultSet.getDate(COLUMN_DATE);

        return new Appointment(
                id,patientId,doctorId,description,date
        );
    }

    @Override
    protected void prepareInsertStatement(PreparedStatement preparedStatement, Appointment entity) throws SQLException {
        preparedStatement.setInt(1, entity.getPatientId());
        preparedStatement.setInt(2, entity.getDoctorId());
        preparedStatement.setString(3, entity.getDescription());
        preparedStatement.setDate(4, entity.getDate());
    }
}
