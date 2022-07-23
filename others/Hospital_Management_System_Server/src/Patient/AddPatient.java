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

public class AddPatient extends Thread{


    public AddPatient() {

    }

    public static void add_patient(Patient patient) {
        try {
            System.out.println("add patient");


            PatientDao patientDao = new PatientDao();
            new Thread(() -> {

                patientDao.addEntity(patient);
            }).start();

            String id = String.valueOf(patient.getId());

            File file = new File(id + ".txt");
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                try {
                    fileWriter.write("Patient Name:   " + patient.getFirstName() + "  " + patient.getLastName() + "\n");

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                fileWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
