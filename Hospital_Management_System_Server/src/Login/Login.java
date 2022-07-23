package Login;

import DataTypes.Employee;
import DataTypes.Password;
import app.database.models.employee.EmployeeDao;
import app.database.models.password.PasswordDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Optional;

import static app.database.models.employee.EmployeeTableColumns.COLUMN_PASSWORD;

public class Login extends Thread{

    Socket communication;

    String login[];
    String[] status;
    private ObjectOutputStream outStream;
    ObjectInputStream inStream;

    public Login(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        communication = socket;
       this.inStream = inStream;
       this.outStream = outStream;
        login();
    }


    public void login()
    {
        try {
            login = (String[]) inStream.readObject();
            EmployeeDao employeeDao = new EmployeeDao();
            Optional<Employee> optionalEmployee = employeeDao.findByEmail(login[0]);
            if(optionalEmployee.isPresent()) {
                Employee employeeEmail = optionalEmployee.get();
                int email = employeeEmail.getId();
                Optional<Employee> optionalPassword = employeeDao.findByPassword(login[1]);
                if (optionalPassword.isPresent()) {
                    Employee employeePassword = optionalPassword.get();
                    int password = employeePassword.getId();
                    if (email == password) {
                        System.out.println("Success");
                        status = new String[]{"Success", optionalEmployee.get().getJobType()};
                        outStream.writeObject(status);
                    } else {
                        status = new String[]{"Fail"};
                        System.out.println("fail");
                        outStream.writeObject(status);
                        System.out.println(status[0]);
                    }
                } else {
                    status = new String[]{"Fail"};
                    System.out.println("fail");
                    outStream.writeObject(status);
                    System.out.println(status[0]);
                }
            }
            else {
                status = new String[]{"Fail"};
                System.out.println("fail");
                outStream.writeObject(status);
                System.out.println(status[0]);
            }

            } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        System.out.println("login finish");
        return;
    }

}
