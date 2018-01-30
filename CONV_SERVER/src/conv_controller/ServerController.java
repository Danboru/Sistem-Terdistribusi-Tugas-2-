package conv_controller;

import conv_connection.Koneksi;
import conv_contract.Konversi;
import conv_model.Convert;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danbo
 */
public class ServerController extends UnicastRemoteObject implements Konversi {

    private String hasilKonversi = "";

    public ServerController() throws RemoteException {
    }

    @Override
    public String hasilKonversi(Integer inputBinner, Integer menuPilihan) {

        Controller controller = new Controller(new Koneksi().getConnection());

        switch (menuPilihan) {
            case 1: {
                
                break;
            }

            case 2: {
                break;
            }

            default: {
                try {
                    hasilKonversi = String.valueOf(controller.binaryKeDesimal(inputBinner));
                } catch (SQLException ex) {
                    Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }
        
        return hasilKonversi;
    }

}
