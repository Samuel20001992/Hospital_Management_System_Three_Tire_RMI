package app.database.models.prescription;

import DataTypes.Prescription;
import app.database.BaseMysql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import static app.database.models.prescription.PrescriptionTableColumns.*;

public class PrescriptionDao extends BaseMysql<Prescription> {

    public PrescriptionDao() {
        super("Prescription",TABLE_NAME,COLUMN_ID);
    }

    @Override
    protected Set<String> insertColumns() {
        Set<String> insertColumns = new LinkedHashSet<>();
        insertColumns.add(COLUMN_PATIENT_ID);
        insertColumns.add(COLUMN_DOCTOR_ID);
        insertColumns.add(COLUMN_MEDICINES);
        insertColumns.add(COLUMN_DEADLINE);

        return insertColumns;
    }

    @Override
    protected Prescription getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COLUMN_ID);

        int patientId = resultSet.getInt(COLUMN_PATIENT_ID);

        int doctorId = resultSet.getInt(COLUMN_DOCTOR_ID);

        String medicines = resultSet.getString(COLUMN_MEDICINES);

        Date deadline = resultSet.getDate(COLUMN_DEADLINE);

        Date issuedDate = resultSet.getDate(COLUMN_ISSUED_DATE);

        return new Prescription(id, patientId, doctorId, medicines, deadline, issuedDate);
    }

    @Override
    protected void prepareInsertStatement(PreparedStatement preparedStatement, Prescription entity) throws SQLException {
        preparedStatement.setInt(1,entity.getPatient_id());
        preparedStatement.setInt(2,entity.getDoctor_id());
        preparedStatement.setString(3,entity.getMedicines());
        preparedStatement.setDate(4,entity.getDeadline());

    }
}
