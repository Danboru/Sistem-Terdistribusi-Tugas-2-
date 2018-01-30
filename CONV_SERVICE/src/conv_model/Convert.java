package conv_model;

/**
 *
 * @author danbo
 */
public class Convert {
    
    String bilanganBinner, bilanganHexa, bilanganOktal, bilanganlDesimal;

    public Convert() {
    }

    public Convert(String bilanganBinner, String bilanganHexa, String bilanganOktal, String bilanganlDesimal) {
        this.bilanganBinner = bilanganBinner;
        this.bilanganHexa = bilanganHexa;
        this.bilanganOktal = bilanganOktal;
        this.bilanganlDesimal = bilanganlDesimal;
    }

    public String getBilanganBinner() {
        return bilanganBinner;
    }

    public void setBilanganBinner(String bilanganBinner) {
        this.bilanganBinner = bilanganBinner;
    }

    public String getBilanganHexa() {
        return bilanganHexa;
    }

    public void setBilanganHexa(String bilanganHexa) {
        this.bilanganHexa = bilanganHexa;
    }

    public String getBilanganOktal() {
        return bilanganOktal;
    }

    public void setBilanganOktal(String bilanganOktal) {
        this.bilanganOktal = bilanganOktal;
    }

    public String getBilanganlDesimal() {
        return bilanganlDesimal;
    }

    public void setBilanganlDesimal(String bilanganlDesimal) {
        this.bilanganlDesimal = bilanganlDesimal;
    }

    
    
}
