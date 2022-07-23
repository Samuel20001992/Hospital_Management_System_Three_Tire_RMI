package Delete;

import app.database.models.appointment.AppointmentDao;
import app.database.models.employee.EmployeeDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DeleteAppointment {

    private  ObjectOutputStream outStream;
    private  ObjectInputStream inStream;
    private int id;


    public DeleteAppointment(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {

        this.inStream = inStream;
        this.outStream = outStream;
    }

    public void delete_appointment() throws IOException, ClassNotFoundException {
        this.id = (int) inStream.readObject();
        AppointmentDao appointmentDao = new AppointmentDao();
        appointmentDao.deleteById(id);
    }
}
