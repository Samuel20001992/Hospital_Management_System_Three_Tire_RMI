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

    private int id;

    public EditPerscription(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {

        add_Perscription();
    }

    private void add_Perscription() {   try {


        PrescriptionDao prescriptionDao = new PrescriptionDao();

        prescriptionDao.updateById(prescription.getId(),prescription);



    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    }
}
