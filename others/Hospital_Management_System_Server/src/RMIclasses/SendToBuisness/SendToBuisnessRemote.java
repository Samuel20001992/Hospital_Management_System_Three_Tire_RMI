package RMIclasses.SendToBuisness;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SendToBuisnessRemote extends UnicastRemoteObject  implements Calc {
    public SendToBuisnessRemote()throws Exception{
        super();
    }
    @Override
    public double add(double x, double y) throws RemoteException {
        return x+y;
    }


    @Override
    public String[] s(String[] u) throws RemoteException {
        return u;
    }
}
