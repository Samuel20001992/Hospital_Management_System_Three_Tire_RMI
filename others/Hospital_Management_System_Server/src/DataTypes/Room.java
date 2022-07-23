package DataTypes;

import app.database.BaseModel;

import java.io.Serializable;

public class Room extends BaseModel implements Serializable {
    private static final long serialVersionUID= 652968;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    int roomNo;
    int patientId = -1;

    public Room(int id, int roomNo, int patientId) {
        this.id = id;
        this.roomNo = roomNo;
        this.patientId = patientId;
    }

    public Room(int roomNo, int patientId) {
        this.roomNo = roomNo;
        this.patientId = patientId;
    }

    public Room(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNo=" + roomNo +
                ", patientId=" + patientId +
                '}';
    }

    @Override
    protected Room clone() throws CloneNotSupportedException {
        return new Room(
                getId(),
                getRoomNo(),
                getPatientId()

        );
    }
}
