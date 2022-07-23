package Search;

import DataTypes.Employee;
import app.database.models.employee.EmployeeDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SearchEmployee extends Thread{
    static ArrayList<String> read_employee = new ArrayList<String>();

    public SearchEmployee() throws IOException, ClassNotFoundException {
        search_Employee();
    }
    public void search_Employee() throws IOException, ClassNotFoundException {

        EmployeeDao employeeDao = new EmployeeDao();

        new Thread(()->{
            System.out.println("read employee");
            List<Employee> employeeList = employeeDao.findByColumn(searchItems[0],searchItems[1]);
            employeeList.forEach(System.out::println);


        }).start();

    }
}



