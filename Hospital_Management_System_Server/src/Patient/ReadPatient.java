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

    Socket communication;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;

    public ReadPatient(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        communication = socket;
        communication = socket;
        this.inStream= inStream;
        this.outStream = outStream;
        read_Patient();
    }
    public void read_Patient(){


            new Thread(() -> {
                PatientDao patientDao = new PatientDao();
                List<Patient> patientList = patientDao.getAllEntities();
                try {
                    outStream.writeObject(patientList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            System.out.println("read finished");


        }
    }


