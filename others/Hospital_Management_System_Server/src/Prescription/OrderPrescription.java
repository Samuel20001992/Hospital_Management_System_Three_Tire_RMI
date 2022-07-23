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

    public OrderPrescription() {

    }

    public static void add_Prescription(Prescription prescription) {

                System.out.println("add prescription");


                PrescriptionDao prescriptionDao = new PrescriptionDao();
                new Thread(() -> {

                    prescriptionDao.addEntity(prescription);
                }).start();




    }
}
