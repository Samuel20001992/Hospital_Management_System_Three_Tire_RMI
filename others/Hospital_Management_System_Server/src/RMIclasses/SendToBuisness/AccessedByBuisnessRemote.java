package RMIclasses.SendToBuisness;

import Appointment.*;
import Patient.*;
import Employee.*;
import DataTypes.*;
import room.AddRoom;
import Prescription.*;
import room.ReadRoom;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class AccessedByBuisnessRemote extends UnicastRemoteObject  implements AccessedByBuisnessInterface {
    public AccessedByBuisnessRemote()throws Exception{
        super();
    }

    @Override
    public void addAppointment(Appointment appointment) throws IOException, ClassNotFoundException {
        Add_Appointment.add(appointment);
    }

    @Override
    public void addPatient(Patient patient) throws RemoteException {
        AddPatient.add_patient(patient);
    }

    @Override
    public void addEmployee(Employee employee, String password) throws RemoteException {
        AddEmployee.add_Employee(employee,password);
    }

    @Override
    public void addRoom(Room room) throws RemoteException {

    }

    @Override
    public void addPrescription(Prescription prescription) throws RemoteException {
       OrderPrescription.add_Prescription(prescription);
    }

    @Override
    public void addDepartment(Department department) throws RemoteException {

    }

    @Override
    public void addPatientToRoom(int id,Room room) throws RemoteException {
        AddRoom.add_Room(id,room);
    }

    @Override
    public Appointment accessAppointmentData() throws RemoteException {
        return ReadAppointment.read_appointment();
    }

    @Override
    public Patient accessPatientData() throws RemoteException {
        return ReadPatient.read_Patient();
    }

    @Override
    public Employee accessEmployeeData() throws RemoteException {
        return ReadEmployee.read_Employee();
    }

    @Override
    public Room accessRoomData() throws RemoteException {
        return ReadRoom.read_Room();
    }

    @Override
    public Department accessDepartmentData() throws RemoteException {
        return null;
    }

    @Override
    public Prescription accessPrescriptionData() throws RemoteException {
        return ReadPrescription.read_Prescription();
    }

    @Override
    public Appointment searchAppointmentData(String searchBy, String value) throws RemoteException {
        return null;
    }

    @Override
    public Patient searchPatientData(String searchBy, String value) throws RemoteException {
        return null;
    }

    @Override
    public Employee searchEmployeeData(String searchBy, String value) throws RemoteException {
        return null;
    }

    @Override
    public Room searchRoomData(String searchBy, String value) throws RemoteException {
        return null;
    }

    @Override
    public Department searchDepartmentData(String searchBy, String value) throws RemoteException {
        return null;
    }

    @Override
    public Prescription searchPrescriptionData(String searchBy, String value) throws RemoteException {
        return null;
    }

    @Override
    public String editAppointmentData(String id, Appointment appointment) throws RemoteException {
        return null;
    }

    @Override
    public String editPatientData(String id, Patient patient) throws RemoteException {
        return null;
    }

    @Override
    public String editEmployeeData(String id, Employee employee) throws RemoteException {
        return null;
    }

    @Override
    public String editRoomData(Room room) throws RemoteException {
        return null;
    }

    @Override
    public String editDepartmentData(Department department) throws RemoteException {
        return null;
    }

    @Override
    public String editPrescriptionData(Prescription prescription) throws RemoteException {
        return null;
    }
}
