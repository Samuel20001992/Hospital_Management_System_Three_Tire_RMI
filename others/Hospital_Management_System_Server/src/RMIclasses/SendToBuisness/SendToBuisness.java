package RMIclasses.SendToBuisness;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SendToBuisness extends Remote {
    public double add (double x, double y) throws RemoteException;
    public String[] s(String[] u) throws RemoteException;

}
