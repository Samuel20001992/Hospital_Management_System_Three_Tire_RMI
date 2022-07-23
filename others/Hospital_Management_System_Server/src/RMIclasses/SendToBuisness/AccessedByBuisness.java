package RMIclasses.SendToBuisness;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class AccessedByBuisness {
    public static void main(String[] args) throws Exception {
        AccessedByBuisnessRemote stub = new AccessedByBuisnessRemote();
        LocateRegistry.createRegistry(5000);
        Naming.rebind("rmi://localhost:5000/stub",stub);
        System.out.println("server started\n");
    }
}
