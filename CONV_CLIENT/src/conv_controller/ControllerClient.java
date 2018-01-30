package conv_controller;

import conv_contract.Konversi;
import conv_model.Convert;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danbo
 */
public class ControllerClient implements Konversi {

    Registry registry = null;
    Konversi serviceContract = null;
    private String hasilKonversi = "";
    
    public ControllerClient() throws RemoteException, NotBoundException  {
        
        registry = LocateRegistry.getRegistry("localhost", 3333);        
        serviceContract = (Konversi) registry.lookup("Server");//Case Sensitive
    }
    

    @Override
    public String hasilKonversi(Integer inputBinner, Integer menuPilihan) throws RemoteException, SQLException {
        
        switch (menuPilihan) {
            case 1: {
                hasilKonversi = String.valueOf(serviceContract.hasilKonversi(inputBinner, menuPilihan));
                break;
            }

            case 2: {
                hasilKonversi = String.valueOf(serviceContract.hasilKonversi(inputBinner, menuPilihan));
                break;
            }

            default: {
                hasilKonversi = String.valueOf(serviceContract.hasilKonversi(inputBinner, menuPilihan));
                break;
            }
        }
        return hasilKonversi;
    }
           
}
