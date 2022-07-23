package Delete;

import app.database.models.employee.EmployeeDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DeleteEmployee {

    private  ObjectOutputStream outStream;
    private  ObjectInputStream inStream;
    private int id;


    public DeleteEmployee(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {

        this.inStream = inStream;
        this.outStream = outStream;
    }

    public void delete_employee_main() throws IOException, ClassNotFoundException {
        this.id = (int) inStream.readObject();
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.deleteById(id);
    }
}
