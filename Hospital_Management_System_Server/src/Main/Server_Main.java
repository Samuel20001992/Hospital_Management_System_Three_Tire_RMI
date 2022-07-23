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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static app.database.models.employee.EmployeeTableColumns.COLUMN_JOB_TYPE;

public class Server_Main
{
    public static ServerSocket serverSocket;
    public static final int PORT= 1123;
    public static Socket socket;
    public static ObjectInputStream inStream;
    public static ObjectOutputStream outStream;

    public static ArrayList<String> data;
    public static String status;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(PORT);
            while(true) {
                socket = serverSocket.accept();
                inStream = new ObjectInputStream( socket.getInputStream());
                outStream = new ObjectOutputStream(socket.getOutputStream());
                Main main = new Main(socket,inStream,outStream);
                main.start();

            }



    } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//    } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
static class Main extends Thread {

    public Main(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) throws IOException, ClassNotFoundException, InterruptedException {

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


        outStream.writeObject(count);
        outStream.writeObject(doctors);


        while (true){
            String choice = (String) inStream.readObject();
            System.out.println(choice);
            System.out.println("call");
        switch (choice) {
            case "Login":
                Login login_handler = new Login(socket, inStream, outStream);
                login_handler.start();
                login_handler.join();
                break;
            case "Add Patient":
                System.out.println("add");
                AddPatient add_patient = new AddPatient(socket, inStream, outStream);
                add_patient.start();
                add_patient.join();
                break;
            case "Read Patient":
                System.out.println("read");
                ReadPatient read_patient = new ReadPatient(socket, inStream, outStream);
                read_patient.start();
                break;
            case "Add Employee":

                AddEmployee add_employee = new AddEmployee(socket, inStream, outStream);
                add_employee.start();
                break;
            case "Read Employee":
                System.out.println("read employee");

                ReadEmployee read_employee = new ReadEmployee(socket, inStream, outStream);
                read_employee.start();
                break;
            case "Order Prescription":
                System.out.println("order prescription");
                OrderPrescription add_perscription = new OrderPrescription(socket, inStream, outStream);
                add_perscription.start();
                break;
            case "Read Prescription":
                ReadPrescription read_perscription = new ReadPrescription(socket, inStream, outStream);
                read_perscription.start();
                break;
            case "Write Dignosis":
                    AddToFile add_to_file = new AddToFile(socket, inStream, outStream);
                    add_to_file.start();
                break;
            case "Read Dignosis":
                    ReadFile read_file = new ReadFile(socket, inStream, outStream);
                       read_file.start();
                break;
            case "Edit Employee":
                EditEmployee edit_employee = new EditEmployee(socket, inStream, outStream);
                edit_employee.start();
                break;
            case "Edit Patient":
                EditPatient edit_patient = new EditPatient(socket, inStream, outStream);
                edit_patient.start();
                break;
            case "Edit Prescription":
                EditPerscription edit_perscription = new EditPerscription(socket, inStream, outStream);
                edit_perscription.start();
                break;

            case "Delete Patient":
                    DeletePatient delete_patient = new DeletePatient(socket, inStream, outStream);
                    delete_patient.delete_patient_main();
                break;
            case "Delete Employee":
                    DeleteEmployee delete_employee = new DeleteEmployee(socket, inStream, outStream);
                    delete_employee.delete_employee_main();
                break;
            case "Delete Prescription":
                    DeletePerscription delete_perscription = new DeletePerscription(socket,inStream, outStream);
                    delete_perscription.delete_prescripiton_main();
                break;

            case "Search Patient":
                    SearchPatient search_patient = new SearchPatient(socket, inStream, outStream);
                    search_patient.start();
                break;
            case "Search Employee":
                    SearchEmployee search_employee = new SearchEmployee(socket, inStream, outStream);
                    search_employee.start();
                break;
            case "Search Prescription":
                    SearchPrescription search_perscription = new SearchPrescription(socket, inStream, outStream);
                    search_perscription.start();
                break;
            case "Add Appointment":
                Add_Appointment add_appointment = new Add_Appointment(socket, inStream, outStream);
                add_appointment.add();
                break;
            case "Read Appointment":
                    ReadAppointment readAppointment = new ReadAppointment(socket, inStream, outStream);
                    readAppointment.start();
                break;
            case "Search Appointment":
                SearchAppointment searchAppointment = new SearchAppointment(socket, inStream, outStream);
                searchAppointment.start();
                break;
            case "Add Room":
               AddRoom addRoom = new AddRoom(socket, inStream, outStream);
                addRoom.start();
                break;
            case "Read Room":
                ReadRoom readRoom = new ReadRoom(socket, inStream, outStream);
                readRoom.start();
                break;
            case "Search Room":
                SearchRoom searchRoom = new SearchRoom(socket, inStream, outStream);
                searchRoom.start();
                break;

            case "Delete Appointment":
                DeleteAppointment deleteAppointment = new DeleteAppointment(socket, inStream, outStream);
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