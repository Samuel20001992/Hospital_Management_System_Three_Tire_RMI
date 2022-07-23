package RMIclasses.AccessBuisness;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AccessingClientInterface extends Remote {
    public void sendToServer() throws RemoteException;
    public void validatePatient() throws RemoteException;
    public void validateEmployee() throws RemoteException;
    public void validatePrescription() throws RemoteException;
    public void receiveFromServer() throws RemoteException;

}
