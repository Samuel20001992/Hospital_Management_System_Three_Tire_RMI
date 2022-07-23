package RMIclasses.SendToBuisness;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class SendToBuisnessServer {
    public static void main(String[] args) throws Exception {
        Calc stub = new SendToBuisnessRemote();
        LocateRegistry.createRegistry(5000);
        Naming.rebind("rmi://localhost:5000/stub",stub);
        System.out.println("server started\n");
    }
}
