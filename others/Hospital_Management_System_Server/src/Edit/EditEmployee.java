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



    public EditEmployee() {

        edit_Employee();
    }
    public void edit_Employee(){
        try {

            EmployeeDao employeeDao = new EmployeeDao();


            employeeDao.updateById(id,employee);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
