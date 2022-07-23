package app;

import DataTypes.Employee;
import DataTypes.Room;
import app.database.models.employee.EmployeeDao;
import app.database.models.employee.EmployeeTableColumns;
import app.database.models.room.RoomDao;

import java.util.ArrayList;
import java.util.List;

import static app.database.models.employee.EmployeeTableColumns.COLUMN_JOB_TYPE;

public class Main {

    public static void main(String[] args)  {

        EmployeeDao employeeDao = new EmployeeDao();

        List<Employee> employees = employeeDao.findByColumn(COLUMN_JOB_TYPE,"Doctor");

        List<Integer> ids = new ArrayList<>();

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            ids.add(employee.getId());
        }

        ids.forEach(System.out::println);
        System.out.println(employeeDao.countByColumn(COLUMN_JOB_TYPE,"Doctor"));


    }

}
