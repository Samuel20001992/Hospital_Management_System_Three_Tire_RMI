package Prescription;

import DataTypes.Patient;
import DataTypes.Prescription;
import app.database.models.patient.PatientDao;
import app.database.models.prescription.PrescriptionDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class OrderPrescription extends Thread {
    static ArrayList<Prescription> add_prescription= new ArrayList<Prescription>();
    Socket communication;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;

    public OrderPrescription(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        this.inStream= inStream;
        this.outStream = outStream;
        add_Perscription();
    }

    private void add_Perscription() {

            try {
                System.out.println("add prescription");

                Prescription prescription = (Prescription) inStream.readObject();
                PrescriptionDao prescriptionDao = new PrescriptionDao();
                new Thread(() -> {

                    prescriptionDao.addEntity(prescription);
                }).start();


            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

    }
}
