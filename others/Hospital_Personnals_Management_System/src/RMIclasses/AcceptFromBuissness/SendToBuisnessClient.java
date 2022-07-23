package RMIclasses.AcceptFromBuissness;

import RMIclasses.SendToBuisness.Calc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class SendToBuisnessClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Calc stub = (Calc) Naming.lookup("rmi://localhost:5000/stub");
        System.out.println(stub.add(2,3));
        String t[] = {"my name is samuel"};
        String k[]= stub.s(t);
        System.out.println(k[0]);
    }
}
