package Appointment;

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

public class ReadAppointment extends Thread{
    static ArrayList<String> read_employee = new ArrayList<String>();

    Socket communication;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;

    public ReadAppointment(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        communication = socket;
        this.inStream= inStream;
        this.outStream = outStream;
        read_appointment();
    }
    public void read_appointment(){

        AppointmentDao appointmentDao = new AppointmentDao();

        // String searchItems[] = (String[]) inStream.readObject();
        new Thread(()->{
            System.out.println("read appointment");
            List<Appointment> appointmentList = appointmentDao.getAllEntities();
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



