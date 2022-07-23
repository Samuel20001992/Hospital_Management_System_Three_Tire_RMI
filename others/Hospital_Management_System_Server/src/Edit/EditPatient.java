package Edit;

import DataTypes.Patient;
import app.database.models.patient.PatientDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class EditPatient extends Thread {
    static ArrayList<String> edit_patient = new ArrayList<String>();

    private int id;

    public EditPatient() {

        edit_Patient();
    }
    public void edit_Patient(){
        try {



            PatientDao patientDao = new PatientDao();

            patientDao.updateById(id,patient);



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
