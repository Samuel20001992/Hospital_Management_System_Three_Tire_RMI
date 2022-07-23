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

public class Login extends Thread{

    Socket communication;

    String login[];
    String[] status;


    public Login() {

        login();
    }


    public void login()
    {
        try {


            EmployeeDao employeeDao = new EmployeeDao();
            Optional<Employee> optionalEmployee = employeeDao.findByEmail(login[0]);
            if (optionalEmployee.isPresent()) {
                Employee employee = optionalEmployee.get();
                PasswordDao passwordDao = new PasswordDao();

                Optional<Password> password = passwordDao.findByPassword(login[1]);
                if (password.isPresent()) {
                        System.out.println("Success");
                         status = new String[]{"Success", optionalEmployee.get().getJobType()};

                    } else {
                        status = new String[]{"Fail"};
                        System.out.println("fail");

                        System.out.println(status[0]);
                    }
                }else {
                status = new String[]{"Fail"};
                System.out.println("fail");

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
