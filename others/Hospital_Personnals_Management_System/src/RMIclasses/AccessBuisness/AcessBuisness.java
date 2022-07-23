package RMIclasses.AccessBuisness;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AcessBuisness {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        AccessingClientRemote stub = (AccessingClientRemote) Naming.lookup("rmi://localhost:5000/stub");

    }
}
