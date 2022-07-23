import DataTypes.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class AcessServer {
    static AccessedByBuisnessInterface stub;


    public AcessServer() throws RemoteException, NotBoundException, MalformedURLException {
        stub = (AccessedByBuisnessInterface) Naming.lookup("rmi://localhost:5000/stub");
        System.out.println("Buisness started");
    }

    public static void add_appointment(Appointment appointment) throws IOException, ClassNotFoundException { stub.addAppointment(appointment); }

    public static String add_patient(Patient patient) throws RemoteException {return stub.addPatient(patient);}

    public static String add_employee(Employee employee) throws RemoteException {return stub.addEmployee(employee);}

    public static void add_prescription(Prescription prescription) throws RemoteException {stub.addPrescription(prescription);}

   public static String add_patient_to_room(int id, Room room) throws RemoteException {return stub.addPatientToRoom(id,room);

   }

    public static List<Appointment> display_appointment() throws RemoteException {return  stub.accessAppointmentData();}

    public static List<Patient> display_patient() throws RemoteException {return stub.accessPatientData();}

    public static List<Employee> display_employee() throws RemoteException {return stub.accessEmployeeData();}

    public static List<Prescription> display_prescription() throws RemoteException {return stub.accessPrescriptionData();}

    public static List<Room> display_room() throws RemoteException {return stub.accessRoomData();}

    public static List<Appointment> search_appointment(String searchBy, String value) throws IOException, ClassNotFoundException {return stub.searchAppointmentData(searchBy,value);}

    public static List<Patient> search_patient(String searchBy, String value) throws IOException, ClassNotFoundException {return stub.searchPatientData(searchBy, value);}

    public static List<Employee> search_employee(String searchBy, String value) throws IOException, ClassNotFoundException {return stub.searchEmployeeData(searchBy,value);}

    public static List<Prescription> search_prescription(String searchBy, String value) throws IOException, ClassNotFoundException {return stub.searchPrescriptionData(searchBy, value);}

    public static List<Room> search_room(String searchBy, String value) throws IOException, ClassNotFoundException {return stub.searchRoomData(searchBy,value);}


    public static String edit_appointment(int id, Appointment appointment) throws RemoteException { return stub.editAppointmentData(id, appointment);}

    public static String edit_patient(int id, Patient patient) throws RemoteException {return stub.editPatientData(id, patient);}

    public static String edit_employee(int id, Employee employee) throws RemoteException { return stub.editEmployeeData(id,employee);}

    public static String edit_prescription(int id, Prescription prescription) throws RemoteException {return stub.editPrescriptionData(id, prescription);}

    public static String edit_Room(int id , Room room) throws RemoteException{return stub.editRoomData(id,room);}

    public static String delete_appointment(int id) throws IOException, ClassNotFoundException {
        return stub.deleteAppointment(id);
    }
    public static String delete_employee(int id) throws IOException, ClassNotFoundException {
        return stub.deleteEmployee(id);
    }
    public static String delete_patient(int id) throws IOException, ClassNotFoundException {
        return stub.deletePatient(id);

    }
    public static String delete_prescription(int id) throws IOException, ClassNotFoundException {
        return stub.deletePrescription(id);
    }
    public static String[] login(String username, String password) throws RemoteException {
        return stub.login(username,password);
    }

}
