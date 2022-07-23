package Delete;

import app.database.models.patient.PatientDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DeletePatient {
    private  ObjectOutputStream outStream;
    private  ObjectInputStream inStream;
    private  int id;


    public DeletePatient( Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        this.inStream= inStream;
        this.outStream = outStream;

    }

    public void delete_patient_main() throws IOException, ClassNotFoundException {
        id = (int) inStream.readObject();
       PatientDao patientDao = new PatientDao();
       patientDao.deleteById(id);
    }
}
