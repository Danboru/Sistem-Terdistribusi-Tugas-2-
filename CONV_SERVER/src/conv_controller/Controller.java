package conv_controller;

import conv_contract.Konversi;
import conv_model.Convert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danbo
 */
public class Controller {

    private final String tableName = "tb_konversi";

    private Connection connectionDatabase;

    public Controller(Connection connection) {
        this.connectionDatabase = connection;
    }

    public List<Convert> getAllHasilKonversi() {

        List<Convert> hasilKonversi = new ArrayList<>();

        try {
            PreparedStatement fetchData = connectionDatabase.prepareStatement("SELECT * FROM " + tableName);
            ResultSet resultDatabase = fetchData.executeQuery();

            while (resultDatabase.next()) {
                Convert konversi = new Convert();
                konversi.setBilanganBinner(resultDatabase.getString(1));
                konversi.setBilanganHexa(resultDatabase.getString(2));
                konversi.setBilanganOktal(resultDatabase.getString(3));
                konversi.setBilanganlDesimal(resultDatabase.getString(4));
                hasilKonversi.add(konversi);
            }
        } catch (Exception e) {
        }

        return hasilKonversi;
    }

    public int getHasilKonversi(int indexPilihan) {

        int hasilKonversi = 0;
        try {
            PreparedStatement fetchData = connectionDatabase.prepareStatement("SELECT * FROM " + tableName);
            ResultSet resultDatabase = fetchData.executeQuery();

            hasilKonversi = Integer.parseInt(resultDatabase.getString(indexPilihan));

        } catch (Exception e) {
        }

        return hasilKonversi;
    }

    public boolean inputKeDatabase(Convert convert) throws SQLException {

        PreparedStatement prepareStatement = connectionDatabase.prepareStatement("INSERT INTO " + tableName + " VALUES (?,?,?,?)");
        prepareStatement.setString(1, convert.getBilanganBinner());
        prepareStatement.setString(2, convert.getBilanganHexa());
        prepareStatement.setString(3, convert.getBilanganOktal());
        prepareStatement.setString(4, convert.getBilanganlDesimal());

        if (prepareStatement.executeUpdate() == 1) {
            return true;
        } else {
            return false;
        }
    }

    //Taken from : https://www.javatpoint.com/java-binary-to-decimal
    public int binaryKeDesimal(int binary) throws SQLException {

        String binnerNya = String.valueOf(binary);
        int decimal = 0;
        int n = 0;
        while (true) {
            if (binary == 0) {
                break;
            } else {
                int temp = binary % 10;
                decimal += temp * Math.pow(2, n);
                binary = binary / 10;
                n++;
            }
        }

        inputKeDatabase(new Convert(binnerNya, "-", "-", String.valueOf(decimal)));

        return decimal;
    }

    //Taken from : https://www.programiz.com/java-programming/examples/binary-octal-convert
    public long binaryKeOktal(long binaryNumber) throws SQLException {
        
        String binnerNya = String.valueOf(binaryNumber);
        int octalNumber = 0, decimalNumber = 0, i = 0;

        while (binaryNumber != 0) {
            decimalNumber += (binaryNumber % 10) * Math.pow(2, i);
            ++i;
            binaryNumber /= 10;
        }

        i = 1;

        while (decimalNumber != 0) {
            octalNumber += (decimalNumber % 8) * i;
            decimalNumber /= 8;
            i *= 10;
        }
        
        inputKeDatabase(new Convert(binnerNya, "-", String.valueOf(octalNumber) ,"-"));

        return octalNumber;
    }

    //Taken from : https://codescracker.com/java/program/java-program-convert-binary-to-hexadecimal.htm
    public String binaryKeHexa(int binary) throws SQLException {

        int rem;
        String hexdecNum = "";
        String binnerNya = String.valueOf(binary);

        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (binary > 0) {
            rem = binary % 16;
            hexdecNum = hex[rem] + hexdecNum;
            binary = binary / 16;
        }

        inputKeDatabase(new Convert(binnerNya, hexdecNum ,"-", "-"));
        
        return hexdecNum;
    }

}
