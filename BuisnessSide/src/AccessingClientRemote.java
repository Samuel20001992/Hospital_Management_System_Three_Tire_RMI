import DataTypes.*;
import Validate.Validate;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class AccessingClientRemote extends UnicastRemoteObject  implements AccessingClientInterface {

    protected AccessingClientRemote() throws RemoteException {

    }


    @Override
    public void addBAppointment(Appointment appointment) throws IOException, ClassNotFoundException {
        AcessServer.add_appointment(appointment);
    }

    @Override
    public String addBPatient(Patient patient) throws RemoteException {
        if(Validate.validate_Patient(patient)=="success") {
            return AcessServer.add_patient(patient);
        }
        else{
            return Validate.validate_Patient(patient);
        }
    }

    @Override
    public String addBEmployee(Employee employee) throws RemoteException {
        if(Validate.validate_Employee(employee)=="success") {
            return AcessServer.add_employee(employee);
        }
        else {
            return Validate.validate_Employee(employee);
        }
    }

    @Override
    public String addBRoom(int id, Room room) throws RemoteException {
           return AcessServer.add_patient_to_room(id,room);
    }

    @Override
    public void addBPrescription(Prescription prescription) throws RemoteException {
                AcessServer.add_prescription(prescription);
    }

    @Override
    public void addBDepartment(Department department) throws RemoteException {

    }

    @Override
    public void addBPatientToRoom(int id, Room room) throws RemoteException {
        AcessServer.add_patient_to_room(id,room);
    }

    @Override
    public List<Appointment> accessBAppointmentData() throws RemoteException {
        return AcessServer.display_appointment();
    }

    @Override
    public List<Patient> accessBPatientData() throws RemoteException {
        return AcessServer.display_patient();
    }

    @Override
    public List<Employee> accessBEmployeeData() throws RemoteException {
        return AcessServer.display_employee();
    }

    @Override
    public List<Room> accessBRoomData() throws RemoteException {
        return AcessServer.display_room();
    }

    @Override
    public List<Department> accessBDepartmentData() throws RemoteException {
        return null;
    }

    @Override
    public List<Prescription> accessBPrescriptionData() throws RemoteException {
        return AcessServer.display_prescription();
    }

    @Override
    public List<Appointment> searchBAppointmentData(String searchBy, String value) throws IOException, ClassNotFoundException {
        return AcessServer.search_appointment(searchBy,value);
    }

    @Override
    public List<Patient> searchBPatientData(String searchBy, String value) throws IOException, ClassNotFoundException {
        return AcessServer.search_patient(searchBy,value);
    }

    @Override
    public List<Employee> searchBEmployeeData(String searchBy, String value) throws IOException, ClassNotFoundException {
        return AcessServer.search_employee(searchBy,value);
    }

    @Override
    public List<Room> searchBRoomData(String searchBy, String value) throws IOException, ClassNotFoundException {
        return AcessServer.search_room(searchBy,value);
    }

    @Override
    public List<Department> searchBDepartmentData(String searchBy, String value) throws RemoteException {
        return null;
    }

    @Override
    public List<Prescription> searchBPrescriptionData(String searchBy, String value) throws IOException, ClassNotFoundException {
        return AcessServer.search_prescription(searchBy,value);
    }

    @Override
    public String editBAppointmentData(int id, Appointment appointment) throws RemoteException {
        return AcessServer.edit_appointment(id,appointment);
    }

    @Override
    public String editBPatientData(int id, Patient patient) throws RemoteException {
        return AcessServer.edit_patient(id, patient);
    }

    @Override
    public String editBEmployeeData(int id, Employee employee) throws RemoteException {
        return AcessServer.edit_employee(id, employee);
    }

    @Override
    public String editBRoomData(int id,Room room) throws RemoteException {
        return AcessServer.edit_Room(id,room);
    }

    @Override
    public String editBDepartmentData(int id, Department department) throws RemoteException {
        return null;
    }

    @Override
    public String editBPrescriptionData(int id, Prescription prescription) throws RemoteException {
        return AcessServer.edit_prescription(id, prescription);
    }

    public String deleteBAppointment(int id) throws IOException, ClassNotFoundException {
        return AcessServer.delete_appointment(id);
    }
    public String deleteBEmployee(int id) throws IOException, ClassNotFoundException {
        return AcessServer.delete_employee(id);
    }
    public String deleteBPatient(int id) throws IOException, ClassNotFoundException {
        return AcessServer.delete_patient(id);
    }
    public String deleteBPrescription(int id) throws IOException, ClassNotFoundException {
        return AcessServer.delete_prescription(id);
    }
    public String[] login(String username, String password) throws RemoteException {
        return  AcessServer.login(username,password);
    }
}
