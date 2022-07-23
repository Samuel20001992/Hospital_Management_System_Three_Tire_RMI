package DataTypes;

import org.omg.PortableServer.ServantActivator;

import java.io.Serializable;
import java.sql.Date;

public class Prescription implements Serializable {
    private static final long serialVersionUID= 652968;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private int patient_id;
    private int doctor_id;
    private String medicines;
    private Date deadline;
    private Date issuedDate;

    public Prescription(int id, int patient_id, int doctor_id, String medicines, Date deadline, Date issuedDate) {
        this.id = id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.medicines = medicines;
        this.deadline = deadline;
        this.issuedDate = issuedDate;
    }




    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }


    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", patient_id=" + patient_id +
                ", doctor_id=" + doctor_id +
                ", medicines='" + medicines + '\'' +
                ", deadline=" + deadline +
                ", issuedDate=" + issuedDate +
                '}';
    }


    @Override
    protected Prescription clone() throws CloneNotSupportedException {
        return new Prescription(
                getId(),
                getPatient_id(),
                getDoctor_id(),
                getMedicines(),
                getDeadline(),
                getIssuedDate()
        );
    }

}
