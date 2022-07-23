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

    Socket communication;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;

    public ReadEmployee(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        communication = socket;
        this.inStream= inStream;
        this.outStream = outStream;
        read_Employee();
    }
    public void read_Employee(){

            EmployeeDao employeeDao = new EmployeeDao();


                new Thread(()->{
                    System.out.println("read employee");
                    List<Employee> employeeList = employeeDao.getAllEntities();
                     employeeList.forEach(System.out::println);
                    try {
                        outStream.writeObject(employeeList);
                        System.out.println("send");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }).start();

        }
    }



