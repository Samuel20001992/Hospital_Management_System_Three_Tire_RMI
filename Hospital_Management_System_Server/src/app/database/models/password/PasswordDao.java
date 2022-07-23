package app.database.models.password;

import DataTypes.Password;
import app.database.BaseMysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static app.database.models.password.PasswordTableColumns.*;

public class PasswordDao extends BaseMysql<Password> {

    public PasswordDao() {
        super("",TABLE_NAME,COLUMN_ID);
    }

    @Override
    protected Set<String> insertColumns() {
        Set<String> insertColumns = new LinkedHashSet<>();

        insertColumns.add(COLUMN_ID);
        insertColumns.add(COLUMN_PASSWORD);
        return insertColumns;
    }
    public Optional<Password> findByPassword(String pass) {
        List<Password> passwords = findByColumn(COLUMN_PASSWORD,pass);

        if(passwords.size() != 1) {
            return Optional.empty();
        }

        Password password = passwords.get(0);

        return Optional.of(password);

    }
    @Override
    protected Password getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COLUMN_ID);
        String password = resultSet.getString(COLUMN_PASSWORD);

        return new Password(id, password);
    }

    @Override
    protected void prepareInsertStatement(PreparedStatement preparedStatement, Password entity) throws SQLException {
        preparedStatement.setInt(1,entity.getId());
        preparedStatement.setString(2,entity.getPassword());
    }
}
