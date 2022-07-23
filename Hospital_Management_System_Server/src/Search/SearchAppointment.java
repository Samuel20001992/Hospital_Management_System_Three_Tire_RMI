package Search;

import DataTypes.Appointment;
import DataTypes.Employee;
import app.database.models.appointment.AppointmentDao;
import app.database.models.employee.EmployeeDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SearchAppointment extends Thread{
    static ArrayList<String> read_employee = new ArrayList<String>();

    Socket communication;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;

    public SearchAppointment(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        communication = socket;
        this.inStream= inStream;
        this.outStream = outStream;
        search_Appointment();
    }
    public void search_Appointment() throws IOException, ClassNotFoundException {

        AppointmentDao appointmentDao = new AppointmentDao();

        String searchItems[] = (String[]) inStream.readObject();
        new Thread(()->{
            System.out.println("read appointment");
            List<Appointment> appointmentList = appointmentDao.findByColumn(searchItems[0],searchItems[1]);
            appointmentList.forEach(System.out::println);
            try {
                outStream.writeObject(appointmentList);
                System.out.println("send");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();

    }
}



