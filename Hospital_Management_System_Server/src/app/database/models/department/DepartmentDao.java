package app.database.models.department;

import DataTypes.Department;
import app.database.BaseMysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedHashSet;
import java.util.Set;

import static app.database.models.department.DepartmentTableColumns.*;

public class DepartmentDao extends BaseMysql<Department> {

    public DepartmentDao() {
        super("department",TABLE_NAME,COLUMN_ID);
    }

    @Override
    protected Set<String> insertColumns() {
        Set<String> insertColumns = new LinkedHashSet<>();
        insertColumns.add(COLUMN_NAME);
        insertColumns.add(COLUMN_HEAD_ID);
        insertColumns.add(COLUMN_PHONE_NUMBER);
        insertColumns.add(COLUMN_EMAIL);

        return insertColumns;
    }

    @Override
    protected Department getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COLUMN_ID);

        String name = resultSet.getString(COLUMN_NAME);

        int head_id = resultSet.getInt(COLUMN_HEAD_ID);

        if(resultSet.wasNull()) {
            head_id = -1;
        }

        int phoneNumber = resultSet.getInt(COLUMN_PHONE_NUMBER);

        String email = resultSet.getString(COLUMN_EMAIL);

        return new Department(
                id,name,head_id,phoneNumber,email
        );
    }


    @Override
    protected void prepareInsertStatement(PreparedStatement preparedStatement, Department entity) throws SQLException {

        preparedStatement.setString(1,entity.getName());

        if(entity.getHeadId() == -1) {
            preparedStatement.setNull(2, Types.NULL);
        }
        else {
            preparedStatement.setInt(2,entity.getHeadId());
        }

        preparedStatement.setInt(3,entity.getPhoneNumber());
        preparedStatement.setString(4,entity.getEmail());

    }
}
