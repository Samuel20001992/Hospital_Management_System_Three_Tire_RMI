package Patient;
import DataTypes.Patient;
import app.database.models.patient.PatientDao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Group;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class AddPatient extends Thread{
    Socket communication;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;

    public AddPatient(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        communication = socket;
        this.inStream= inStream;
        this.outStream = outStream;
        add_patient();
    }

    private void add_patient() {
        try {
            System.out.println("add patient");

            Patient patient = (Patient) inStream.readObject();
            PatientDao patientDao = new PatientDao();
            new Thread(()->{

                    patientDao.addEntity(patient);
            }).start();

            String fname = String.valueOf(patient.getFirstName());

            List<Patient> patientList = patientDao.getAllEntities();
            int patientInteger =  patientList.size();
            String pateintString = String.valueOf(patientInteger);
            File file = new File("ID"+ " " + patientInteger + " " + "First Name" + " " + fname + ".txt");
            try {
                FileWriter fileWriter = new FileWriter(file,true);
                try {
                        fileWriter.write("Patient Name:   " + patient.getFirstName() + "  " + patient.getLastName() + "\n");

                    } catch (IOException ioException) {
                        ioException.printStackTrace();}
                fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
