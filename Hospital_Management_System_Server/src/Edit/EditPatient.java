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

    Socket communication;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;
    private int id;

    public EditPatient(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        communication = socket;
        this.inStream= inStream;
        this.outStream = outStream;
        edit_Patient();
    }
    public void edit_Patient(){
        try {

            id = (int) inStream.readObject();

            PatientDao patientDao = new PatientDao();
            Patient patient = (Patient) inStream.readObject();
            patientDao.updateById(id,patient);



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
