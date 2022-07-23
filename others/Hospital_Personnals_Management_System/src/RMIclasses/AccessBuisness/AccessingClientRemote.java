package RMIclasses.AccessBuisness;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AccessingClientRemote extends UnicastRemoteObject  implements AccessingClientInterface {

    protected AccessingClientRemote() throws RemoteException {
    }

    @Override
    public void sendToServer() throws RemoteException {

    }

    public void receiveFromServer() throws RemoteException {

    }

    @Override
    public void validatePatient() throws RemoteException {

    }

    @Override
    public void validateEmployee() throws RemoteException {

    }

    @Override
    public void validatePrescription() throws RemoteException {

    }
}
