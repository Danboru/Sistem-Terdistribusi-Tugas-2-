package conv_contract;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author danbo
 */
public interface Konversi extends Remote {
    
    public String hasilKonversi(Integer inputBinner, Integer menuPilihan) throws RemoteException, SQLException;
    
}
