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

    Socket communication;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;

    public SearchEmployee(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        communication = socket;
        this.inStream= inStream;
        this.outStream = outStream;
        search_Employee();
    }
    public void search_Employee() throws IOException, ClassNotFoundException {

        EmployeeDao employeeDao = new EmployeeDao();

        String searchItems[] = (String[]) inStream.readObject();
        new Thread(()->{
            System.out.println("read employee");
            List<Employee> employeeList = employeeDao.findByColumn(searchItems[0],searchItems[1]);
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



