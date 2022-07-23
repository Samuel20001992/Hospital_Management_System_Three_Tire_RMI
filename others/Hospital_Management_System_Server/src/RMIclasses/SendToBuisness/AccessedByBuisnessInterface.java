package RMIclasses.SendToBuisness;

import DataTypes.*;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface AccessedByBuisnessInterface extends Remote {
    public void addAppointment( Appointment appointment) throws IOException, ClassNotFoundException;
    public void addPatient( Patient patient) throws RemoteException;
    public void addEmployee( Employee employee, String password) throws RemoteException;
    public void addRoom(Room room) throws RemoteException;
    public void addPrescription(Prescription prescription) throws RemoteException;
    public void addDepartment( Department department) throws RemoteException;
    public void addPatientToRoom(int id,Room room) throws RemoteException;

    public Appointment accessAppointmentData() throws RemoteException;
    public Patient accessPatientData() throws RemoteException;
    public Employee accessEmployeeData() throws RemoteException;
    public Room accessRoomData() throws RemoteException;
    public Department accessDepartmentData() throws RemoteException;
    public Prescription accessPrescriptionData() throws RemoteException;

   public Appointment searchAppointmentData(String searchBy, String value) throws RemoteException;
   public Patient searchPatientData(String searchBy, String value) throws RemoteException;
   public Employee searchEmployeeData(String searchBy, String value) throws RemoteException;
   public Room searchRoomData(String searchBy, String value) throws RemoteException;
   public Department searchDepartmentData(String searchBy, String value) throws RemoteException;
   public Prescription searchPrescriptionData(String searchBy, String value) throws RemoteException;

   public String editAppointmentData(String id, Appointment appointment) throws RemoteException;
   public String editPatientData(String id, Patient patient) throws RemoteException;
   public String editEmployeeData(String id, Employee employee) throws RemoteException;
   public String editRoomData(Room room) throws RemoteException;
   public String editDepartmentData(Department department) throws RemoteException;
   public String editPrescriptionData(Prescription prescription) throws RemoteException;
}
