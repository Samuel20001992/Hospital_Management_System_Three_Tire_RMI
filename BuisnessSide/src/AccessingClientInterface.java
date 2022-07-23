import DataTypes.*;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface AccessingClientInterface extends Remote {
    public void addBAppointment( Appointment appointment) throws IOException, ClassNotFoundException;
    public String addBPatient( Patient patient) throws RemoteException;
    public String addBEmployee(Employee employee) throws RemoteException;
    public String addBRoom(int id,Room room) throws RemoteException;
    public void addBPrescription(Prescription prescription) throws RemoteException;
    public void addBDepartment( Department department) throws RemoteException;
    public void addBPatientToRoom(int id,Room room) throws RemoteException;

    public List<Appointment> accessBAppointmentData() throws RemoteException;
    public List<Patient> accessBPatientData() throws RemoteException;
    public List<Employee> accessBEmployeeData() throws RemoteException;
    public List<Room> accessBRoomData() throws RemoteException;
    public List<Department> accessBDepartmentData() throws RemoteException;
    public List<Prescription> accessBPrescriptionData() throws RemoteException;

    public List<Appointment> searchBAppointmentData(String searchBy, String value) throws IOException, ClassNotFoundException;
    public List<Patient> searchBPatientData(String searchBy, String value) throws IOException, ClassNotFoundException;
    public List<Employee> searchBEmployeeData(String searchBy, String value) throws IOException, ClassNotFoundException;
    public List<Room> searchBRoomData(String searchBy, String value) throws IOException, ClassNotFoundException;
    public List<Department> searchBDepartmentData(String searchBy, String value) throws RemoteException;
    public List<Prescription> searchBPrescriptionData(String searchBy, String value) throws IOException, ClassNotFoundException;

    public String editBAppointmentData(int id, Appointment appointment) throws RemoteException;
    public String editBPatientData(int id, Patient patient) throws RemoteException;
    public String editBEmployeeData(int id, Employee employee) throws RemoteException;
    public String editBRoomData(int id, Room room) throws RemoteException;
    public String editBDepartmentData(int id, Department department) throws RemoteException;
    public String editBPrescriptionData(int id, Prescription prescription) throws RemoteException;

    public String deleteBAppointment(int id) throws IOException, ClassNotFoundException;
    public String deleteBEmployee(int id) throws IOException, ClassNotFoundException;
    public String deleteBPatient(int id) throws IOException, ClassNotFoundException;
    public String deleteBPrescription(int id) throws IOException, ClassNotFoundException;
    public String[] login(String username, String password) throws RemoteException;


}
