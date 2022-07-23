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



    public ReadAppointment() {

    }
    public static Appointment read_appointment(){

        AppointmentDao appointmentDao = new AppointmentDao();
         Appointment appointment ;

            System.out.println("read appointment");
            List<Appointment> appointmentList = appointmentDao.getAllEntities();
            appointmentList.forEach(System.out::println);
            appointment = (Appointment) appointmentList;
           return appointment;

    }
}



