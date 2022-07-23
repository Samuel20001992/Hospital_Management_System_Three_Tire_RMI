package Delete;

import app.database.models.prescription.PrescriptionDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DeletePerscription  {


    private  int id;


    public DeletePerscription() {

    }

    public void delete_prescripiton_main() throws IOException, ClassNotFoundException {

           PrescriptionDao  prescriptionDao = new PrescriptionDao();
           prescriptionDao.deleteById(id);
    }
}
