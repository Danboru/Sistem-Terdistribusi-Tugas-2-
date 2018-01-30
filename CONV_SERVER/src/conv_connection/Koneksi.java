package conv_connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author danbo
 */
public class Koneksi {
    
    public Connection connectionDatabase = null;
    
    public Connection getConnection(){
        
        try {
        
        Class.forName("com.mysql.jdbc.Driver");
            
        connectionDatabase = DriverManager.getConnection("jdbc:mysql://localhost:8889/db_konversi", "root", "root");
        //connectionDatabase = DriverManager.getConnection("jdbc:mysql://localhost/test?" + "user=root&password=root");
        
        } catch (Exception e) {
            
        }
        
        return connectionDatabase;
    }
}
