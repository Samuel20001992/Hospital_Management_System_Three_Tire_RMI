package Employee;

import DataTypes.Employee;
import app.database.models.employee.EmployeeDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ReadEmployee extends Thread{
    static ArrayList<String> read_employee = new ArrayList<String>();



    public ReadEmployee() {

    }
    public static Employee read_Employee(){

            EmployeeDao employeeDao = new EmployeeDao();

                    System.out.println("read employee");
                    List<Employee> employeeList = employeeDao.getAllEntities();
                     employeeList.forEach(System.out::println);
                    Employee employee = (Employee) employeeList;
                    return employee;


        }
    }



