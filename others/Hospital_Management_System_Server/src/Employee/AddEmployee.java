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



    public AddEmployee() {

    }
    public static void add_Employee(Employee employee, String password){


            EmployeeDao employeeDao= new EmployeeDao();
           employeeDao.addEntity(employee);

            Password password1 = new Password(
                    0,
                    password
            );
            PasswordDao passwordDao = new PasswordDao();
            passwordDao.addEntity(password1);


    }
}
