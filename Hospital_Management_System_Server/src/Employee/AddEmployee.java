package Employee;

import DataTypes.Employee;
import DataTypes.Password;
import app.database.models.employee.EmployeeDao;
import app.database.models.password.PasswordDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;


public class AddEmployee extends Thread{

    private  ObjectOutputStream outStream;
    private  ObjectInputStream inStream;
    Socket communication;


    public AddEmployee(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        communication = socket;
        this.inStream= inStream;
        this.outStream = outStream;
        add_Employee();
    }
    public void add_Employee(){
        try {

            EmployeeDao employee= new EmployeeDao();
            Employee employeeData =  (Employee) inStream.readObject();
            employee.addEntity(employeeData);



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
