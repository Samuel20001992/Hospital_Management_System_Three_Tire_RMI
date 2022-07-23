package Delete;

import app.database.models.prescription.PrescriptionDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DeletePerscription  {

    private  ObjectOutputStream outStream;
    private  int id;
    private  ObjectInputStream inStream;

    public DeletePerscription(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        this.inStream= inStream;
        this.outStream = outStream;
    }

    public void delete_prescripiton_main() throws IOException, ClassNotFoundException {
        this.id = (int) inStream.readObject();
           PrescriptionDao  prescriptionDao = new PrescriptionDao();
           prescriptionDao.deleteById(id);
    }
}
