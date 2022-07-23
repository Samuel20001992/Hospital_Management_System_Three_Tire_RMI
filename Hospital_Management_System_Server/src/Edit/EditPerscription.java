package Edit;

import DataTypes.Prescription;
import app.database.models.prescription.PrescriptionDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class EditPerscription extends Thread {
    static ArrayList<String> edit_perscription = new ArrayList<String>();

    Socket communication;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;
    private int id;

    public EditPerscription(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        this.inStream= inStream;
        this.outStream = outStream;
        edit_Perscription();
    }

    private void edit_Perscription() {   try {

          id = (int) inStream.readObject();
        PrescriptionDao prescriptionDao = new PrescriptionDao();
        Prescription prescription = (Prescription) inStream.readObject();
        prescriptionDao.updateById(prescription.getId(),prescription);



    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    }
}
