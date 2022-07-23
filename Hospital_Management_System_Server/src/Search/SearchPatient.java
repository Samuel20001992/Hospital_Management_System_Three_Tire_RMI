package Search;

import DataTypes.Employee;
import DataTypes.Patient;
import app.database.models.employee.EmployeeDao;
import app.database.models.patient.PatientDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SearchPatient extends Thread{
    static ArrayList<String> read_employee = new ArrayList<String>();

    Socket communication;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;

    public SearchPatient(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        communication = socket;
        this.inStream= inStream;
        this.outStream = outStream;
        search_Patient();
    }
    public void search_Patient() throws IOException, ClassNotFoundException {

        PatientDao patientDao = new PatientDao();

        String searchItems[] = (String[]) inStream.readObject();
        new Thread(()->{
            System.out.println("read patient");
            List<Patient> patientList = patientDao.findByColumn(searchItems[0],searchItems[1]);
            patientList.forEach(System.out::println);
            try {
                outStream.writeObject(patientList);
                System.out.println("send");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();

    }
}



