package conv_client;

import conv_contract.Konversi;
import conv_controller.ControllerClient;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author danbo
 */
public class CONV_CLIENT {
    
    public static void main(String[] args) throws RemoteException, NotBoundException, SQLException {
       
        String hasilKonversi = "";
        int bilanganBinner;
        int menuPilihan;
        
        Scanner inputUser = new Scanner(System.in);
        ControllerClient controllerClient = new ControllerClient();
          
        System.out.println("Konversi");
        System.out.println("=======");
        
        System.out.print("Masukan Binner : ");
        bilanganBinner = inputUser.nextInt();
        
        System.out.println("");
        
        System.out.println("Pilih Menu : ");
        System.out.println("1. Konversi ke Hexa");
        System.out.println("2. Konversi ke Oktal");
        System.out.println("3. Konversi ke Decimal");
        System.out.println("=================");
        System.out.println("");
        System.out.print("Pilih Menu : ");
        menuPilihan = inputUser.nextInt();
        
        System.out.println("");
        
        hasilKonversi = controllerClient.hasilKonversi(bilanganBinner, menuPilihan);
        System.out.println("Hasil : " + hasilKonversi);
        
        
    }
    
}