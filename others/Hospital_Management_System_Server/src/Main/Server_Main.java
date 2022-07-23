package Main;

import Appointment.Add_Appointment;
import Appointment.ReadAppointment;
import DataTypes.Employee;
import DataTypes.Patient;
import Delete.DeleteAppointment;
import Delete.DeleteEmployee;
import Delete.DeletePatient;
import Delete.DeletePerscription;
import Edit.EditEmployee;
//import Edit.EditPatient;
import Edit.EditPatient;
import Edit.EditPerscription;
import Edit.UpdateRoom;
import Employee.AddEmployee;
import Employee.ReadEmployee;
import FileHandler.AddToFile;
import FileHandler.ReadFile;
import Login.Login;
import Patient.AddPatient;
import Patient.ReadPatient;
import Prescription.OrderPrescription;
import Prescription.ReadPrescription;
import Search.*;
import app.database.models.employee.EmployeeDao;
import app.database.models.patient.PatientDao;
import room.AddRoom;
import room.ReadRoom;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Server;
import java.net.;
import java.util.ArrayList;
import java.util.List;

import static app.database.models.employee.EmployeeTableColumns.COLUMN_JOB_TYPE;

public class Server_Main
{


    public static ArrayList<String> data;
    public static String status;

    public static void main(String[] args) {

    }
static class Main extends Thread {

    public Main() throws IOException, ClassNotFoundException, InterruptedException {

        EmployeeDao employeeDao = new EmployeeDao();

        List<Employee> doctors = employeeDao.findByColumn(COLUMN_JOB_TYPE,"Doctor");

        List<Integer> ids = new ArrayList<>();

        for (int i = 0; i < doctors.size(); i++) {
            Employee employee = doctors.get(i);
            ids.add(employee.getId());
        }
          int doctor = doctors.size();

        List<Employee> adminstrators = employeeDao.findByColumn(COLUMN_JOB_TYPE,"Adminstration");
        int adminstration = adminstrators.size();

        List<Employee> pharmacists = employeeDao.findByColumn(COLUMN_JOB_TYPE,"Pharmacists");
        int pharmacy = pharmacists.size();

        List<Employee> nurses = employeeDao.findByColumn(COLUMN_JOB_TYPE,"Nurse");
        int nurse = nurses.size();


        PatientDao patientDao = new PatientDao();

        List<Patient> patients = patientDao.getAllEntities();
        int patient = patients.size();

        int count[] = {adminstration,doctor,nurse,pharmacy,patient};


        while (true){
           
            System.out.println();
            System.out.println("call");
        switch () {
            case "Login":
                Login login_handler = new Login();
                login_handler.start();
                login_handler.join();
                break;
            case "Add Patient":
                System.out.println("add");
                AddPatient add_patient = new AddPatient(, , );
                add_patient.start();
                add_patient.join();
                break;
            case "Read Patient":
                System.out.println("read");
                ReadPatient read_patient = new ReadPatient(, , );
                read_patient.start();
                break;
            case "Add Employee":

                AddEmployee add_employee = new AddEmployee(, , );
                add_employee.start();
                break;
            case "Read Employee":
                System.out.println("read employee");
                ReadEmployee read_employee = new ReadEmployee(, , );
                read_employee.start();
                break;
            case "Order Prescription":
                System.out.println("order prescription");
                OrderPrescription add_perscription = new OrderPrescription(, , );
                add_perscription.start();
                break;
            case "Read Prescription":
                ReadPrescription read_perscription = new ReadPrescription(, , );
                read_perscription.start();
                break;
            case "Write Dignosis":
                    AddToFile add_to_file = new AddToFile(, , );
                break;
            case "Read Dignosis":
                    ReadFile read_file = new ReadFile(, , );

                break;
            case "Edit Employee":
                EditEmployee edit_employee = new EditEmployee(, , );
                edit_employee.start();
                break;
            case "Edit Patient":
                EditPatient edit_patient = new EditPatient(, , );
                edit_patient.start();
                break;
            case "Edit Prescription":
                EditPerscription edit_perscription = new EditPerscription(, , );
                edit_perscription.start();
                break;
//                case "Edit File":
//                    EditFile edit_file = new EditFile();
//                    edit_file.start();
//                    break;
            case "Delete Patient":
                    DeletePatient delete_patient = new DeletePatient(, , );
                    delete_patient.delete_patient_main();
                break;
            case "Delete Employee":
                    DeleteEmployee delete_employee = new DeleteEmployee(, , );
                    delete_employee.delete_employee_main();
                break;
            case "Delete Prescription":
                    DeletePerscription delete_perscription = new DeletePerscription(,, );
                    delete_perscription.delete_prescripiton_main();
                break;
//                case "Delete File":
//                    DeleteFile delete_file = new DeleteFile();
//                    delete_file.start();
//                    break;
            case "Search Patient":
                    SearchPatient search_patient = new SearchPatient(, , );
                    search_patient.start();
                break;
            case "Search Employee":
                    SearchEmployee search_employee = new SearchEmployee(, , );
                    search_employee.start();
                break;
            case "Search Prescription":
                    SearchPrescription search_perscription = new SearchPrescription(, , );
                    search_perscription.start();
                break;
            case "Add Appointment":
                Add_Appointment add_appointment = new Add_Appointment(, , );
                add_appointment.add();
                break;
            case "Read Appointment":
                    ReadAppointment readAppointment = new ReadAppointment(, , );
                    readAppointment.start();
                break;
            case "Search Appointment":
                SearchAppointment searchAppointment = new SearchAppointment(, , );
                searchAppointment.start();
                break;
            case "Add Room":
               AddRoom addRoom = new AddRoom(, , );
                addRoom.start();
                break;
            case "Read Room":
                ReadRoom readRoom = new ReadRoom(, , );
                readRoom.start();
                break;
            case "Search Room":
                SearchRoom searchRoom = new SearchRoom(, , );
                searchRoom.start();
                break;
//            case "Update Room":
//                UpdateRoom updateRoom = new UpdateRoom(, , );
//                updateRoom.start();
               // break;
            case "Delete Appointment":
                DeleteAppointment deleteAppointment = new DeleteAppointment(, , );
                deleteAppointment.delete_appointment();
                break;
            default:
                System.out.println("not found");
                break;
        }
            }
        }
    }
}