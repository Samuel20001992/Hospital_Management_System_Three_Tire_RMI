package Prescription;

import DataTypes.Prescription;
import app.database.models.prescription.PrescriptionDao;

import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ReadPrescription extends Thread{
    static ArrayList<String> read_perscripiton = new ArrayList<String>();


    public ReadPrescription() {

    }

    public static Prescription read_Prescription() {

        PrescriptionDao prescriptionDao = new PrescriptionDao();
        List<Prescription> prescription = (List<Prescription>) prescriptionDao.getAllEntities();
        Prescription prescription1 = (Prescription) prescription;
        return prescription1;
    }
}
