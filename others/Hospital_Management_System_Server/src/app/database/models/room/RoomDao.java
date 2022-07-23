package app.database.models.room;


import DataTypes.Room;
import app.database.BaseMysql;
import app.database.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static app.database.models.room.RoomTableColumns.*;

public class RoomDao extends BaseMysql<Room> {

    public RoomDao() {
        super("room",TABLE_NAME,COLUMN_ID);
    }

    @Override
    protected Set<String> insertColumns() {
        Set<String> insertColumns = new LinkedHashSet<>();

        insertColumns.add(COLUMN_ROOM_NO);
        insertColumns.add(COLUMN_PATIENT_ID);

        return insertColumns;
    }

    @Override
    protected Room getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COLUMN_ID);
        int roomNo = resultSet.getInt(COLUMN_ROOM_NO);
        int patientId = resultSet.getInt(COLUMN_PATIENT_ID);

        if(resultSet.wasNull()) {
            patientId = -1;
        }

        return new Room(id,roomNo,patientId);
    }

    @Override
    protected void prepareInsertStatement(PreparedStatement preparedStatement, Room entity) throws SQLException {
        preparedStatement.setInt(1,entity.getRoomNo());
        if(entity.getPatientId() == -1) {
            preparedStatement.setNull(2, Types.NULL);
        }
        else {
            preparedStatement.setInt(2,entity.getPatientId());
        }
    }

    public List<Room> getAllOccupiedRooms() {
        List<Room> rooms = new ArrayList<>();

        String query = "select * from " + TABLE_NAME + " where + " + COLUMN_PATIENT_ID + " IS NOT NULL;";

        return selectAllRoomsByQuery(rooms, query);
    }

    public List<Room> getAllFreeRooms() {
        List<Room> rooms = new ArrayList<>();

        String query = "select * from " + TABLE_NAME + " where + " + COLUMN_PATIENT_ID + " IS NULL;";

        return selectAllRoomsByQuery(rooms, query);
    }

    private List<Room> selectAllRoomsByQuery(List<Room> rooms, String query) {
        try {
            Statement statement = DbConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Room room = getEntityFromResultSet(resultSet);
                rooms.add(room);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rooms;
    }
}
