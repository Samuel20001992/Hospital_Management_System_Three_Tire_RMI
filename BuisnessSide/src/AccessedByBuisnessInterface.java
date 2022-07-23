import DataTypes.*;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface AccessedByBuisnessInterface extends Remote {
    public void addAppointment( Appointment appointment) throws IOException, ClassNotFoundException;
    public String addPatient( Patient patient) throws RemoteException;
    public String addEmployee( Employee employee) throws RemoteException;
    public void addRoom(Room room) throws RemoteException;
    public void addPrescription(Prescription prescription) throws RemoteException;
    public void addDepartment( Department department) throws RemoteException;
    public String addPatientToRoom(int id, Room room) throws RemoteException;

    public List<Appointment> accessAppointmentData() throws RemoteException;
    public List<Patient> accessPatientData() throws RemoteException;
    public List<Employee> accessEmployeeData() throws RemoteException;
    public List<Room> accessRoomData() throws RemoteException;
    public List<Department> accessDepartmentData() throws RemoteException;
    public List<Prescription> accessPrescriptionData() throws RemoteException;

    public List<Appointment> searchAppointmentData(String searchBy, String value) throws IOException, ClassNotFoundException;
    public List<Patient> searchPatientData(String searchBy, String value) throws IOException, ClassNotFoundException;
    public List<Employee> searchEmployeeData(String searchBy, String value) throws IOException, ClassNotFoundException;
    public List<Room> searchRoomData(String searchBy, String value) throws IOException, ClassNotFoundException;
    public List<Department> searchDepartmentData(String searchBy, String value) throws RemoteException;
    public List<Prescription> searchPrescriptionData(String searchBy, String value) throws IOException, ClassNotFoundException;

    public String editAppointmentData(int id, Appointment appointment) throws RemoteException;
    public String editPatientData(int id, Patient patient) throws RemoteException;
    public String editEmployeeData(int id, Employee employee) throws RemoteException;
    public String editRoomData(int id,Room room) throws RemoteException;
    public String editDepartmentData(int id,Department department) throws RemoteException;
    public String editPrescriptionData(int id,Prescription prescription) throws RemoteException;

    public String deleteAppointment(int id) throws IOException, ClassNotFoundException;
    public String deleteEmployee(int id) throws IOException, ClassNotFoundException;
    public String deletePatient(int id) throws IOException, ClassNotFoundException;
    public String deletePrescription(int id) throws IOException, ClassNotFoundException;
    public String[] login(String username, String password) throws RemoteException;
}
