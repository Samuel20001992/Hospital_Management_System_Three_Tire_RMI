package Delete;

import app.database.models.employee.EmployeeDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DeleteEmployee {

    private int id;


    public DeleteEmployee() {



    }

    public void delete_employee_main() throws IOException, ClassNotFoundException {

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.deleteById(id);
    }
}
