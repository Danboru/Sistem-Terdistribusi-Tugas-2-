/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conv_controller;

import java.rmi.RemoteException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danbo
 */
public class ServerControllerTest {
    
    @Test
    public void testHasilKonversi() throws RemoteException {
        Integer inputBinner = 1010;
        Integer menuPilihan = 3;
        
        ServerController instance = new ServerController();
        
        String expResult = "10";
        String result = instance.hasilKonversi(inputBinner, menuPilihan);
        
        assertEquals(expResult, result);
    }
    
}
