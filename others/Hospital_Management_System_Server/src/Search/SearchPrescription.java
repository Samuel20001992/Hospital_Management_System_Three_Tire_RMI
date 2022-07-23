package Search;

import DataTypes.Employee;
import DataTypes.Patient;
import DataTypes.Prescription;
import app.database.models.employee.EmployeeDao;
import app.database.models.patient.PatientDao;
import app.database.models.prescription.PrescriptionDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SearchPrescription extends Thread{
    static ArrayList<String> read_employee = new ArrayList<String>();

    public SearchPrescription() throws IOException, ClassNotFoundException {

        search_Patient();
    }
    public void search_Patient() throws IOException, ClassNotFoundException {

        PrescriptionDao prescriptionDao = new PrescriptionDao();

        new Thread(()->{
            System.out.println("read patient");
            List<Prescription> prescriptionList = prescriptionDao.findByColumn(searchItems[0],searchItems[1]);
            prescriptionList.forEach(System.out::println);

        }).start();

    }
}



