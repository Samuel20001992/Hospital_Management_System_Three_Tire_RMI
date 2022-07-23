package Prescription;

import DataTypes.Prescription;
import app.database.models.prescription.PrescriptionDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ReadPrescription extends Thread{
    static ArrayList<String> read_perscripiton = new ArrayList<String>();
    Socket communication;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;

    public ReadPrescription(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        this.inStream= inStream;
        this.outStream = outStream;
        read_Perscription();
    }

    private void read_Perscription() {   try {

        PrescriptionDao prescriptionDao = new PrescriptionDao();
        List<Prescription> prescription = (List<Prescription>) prescriptionDao.getAllEntities();
        outStream.writeObject(prescription);

    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
