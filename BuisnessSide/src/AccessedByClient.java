import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class AccessedByClient {
    public static void main(String[] args) throws Exception {
        AccessingClientRemote stub = new AccessingClientRemote();
        LocateRegistry.createRegistry(6001);
       // System.setProperty("java.rmi.server.hostname", "192.168.43.98");
        Naming.rebind("rmi://localhost:6001/stub", stub);
        System.out.println("server started\n");
         AcessServer acessServer = new AcessServer();
    }
}
