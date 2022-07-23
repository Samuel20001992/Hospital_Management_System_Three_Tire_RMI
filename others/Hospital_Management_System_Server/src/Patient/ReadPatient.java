package Patient;
import DataTypes.Patient;
import app.database.models.patient.PatientDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ReadPatient extends Thread {
    static ArrayList<String> read_patient = new ArrayList<String>();


    public ReadPatient() {

        read_Patient();
    }
    public static Patient read_Patient(){


                PatientDao patientDao = new PatientDao();
                List<Patient> patientList = patientDao.getAllEntities();
                Patient patient = (Patient) patientList;
                System.out.println("read finished");
                return patient;
        }
    }


