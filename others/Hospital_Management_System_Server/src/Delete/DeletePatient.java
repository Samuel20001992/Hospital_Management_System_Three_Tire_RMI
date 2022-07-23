package Delete;

import app.database.models.patient.PatientDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DeletePatient {

    private  int id;


    public DeletePatient( Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {


    }

    public void delete_patient_main() throws IOException, ClassNotFoundException {

       PatientDao patientDao = new PatientDao();
       patientDao.deleteById(id);
    }
}
