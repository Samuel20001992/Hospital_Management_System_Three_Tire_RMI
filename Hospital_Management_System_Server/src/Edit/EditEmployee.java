package Edit;

import DataTypes.Employee;
import app.database.models.employee.EmployeeDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class EditEmployee extends Thread {

    static int id;

    Socket communication;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;

    public EditEmployee(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        communication = socket;
        this.inStream= inStream;
        this.outStream = outStream;
        edit_Employee();
    }
    public void edit_Employee(){
        try {

            id = (int) inStream.readObject();


            EmployeeDao employeeDao = new EmployeeDao();
            Employee  employee = (Employee) inStream.readObject();

            employeeDao.updateById(id,employee);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
