package Delete;

import app.database.models.appointment.AppointmentDao;
import app.database.models.employee.EmployeeDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DeleteAppointment {


    private int id;


    public DeleteAppointment() {


    }

    public void delete_appointment() throws IOException, ClassNotFoundException {

        AppointmentDao appointmentDao = new AppointmentDao();
        appointmentDao.deleteById(id);
    }
}
