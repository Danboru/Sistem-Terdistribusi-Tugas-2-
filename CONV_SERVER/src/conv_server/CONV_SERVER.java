package conv_server;

import conv_connection.Koneksi;
import conv_controller.ServerController;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author danbo
 */
public class CONV_SERVER {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        ServerController databaseController = new ServerController();
        
        Registry reg = LocateRegistry.createRegistry(3333);
        
        //Server Name
        reg.bind("Server", databaseController); //Di butuhkan di class ControllerClient
        
        System.out.println(new Koneksi().getConnection());
        System.out.println("Server is running ...");
        
    }
    
}
