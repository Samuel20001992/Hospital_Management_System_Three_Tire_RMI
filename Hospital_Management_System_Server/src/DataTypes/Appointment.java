package DataTypes;

import app.database.BaseModel;

import java.io.Serializable;
import java.sql.Date;

public class Appointment extends BaseModel implements Serializable {
    private static final long serialVersionUID= 652968;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private  int id;
    private int patientId,doctorId;
    private String description;
    private Date date;

    public Appointment(int id, int patientId, int doctorId, String description, Date date) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.description = description;
        this.date = date;
    }

    public Appointment(int patientId, int doctorId, String description, Date date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.description = description;
        this.date = date;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String
    toString() {
        return "Appointment{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public Appointment clone() throws CloneNotSupportedException {
        return new Appointment(
                getId(),
                getPatientId(),
                getDoctorId(),
                getDescription(),
                getDate()
        );
    }

}
