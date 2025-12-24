
package Test;
import tr.edu.istiklal.HexFormatException;
import tr.edu.istiklal.HexToDecimal;

public class Test {
    public static void main(String[] args) {

        try {
            System.out.println(HexToDecimal.hex2Dec("1A3F")); // doğru
            System.out.println(HexToDecimal.hex2Dec("12G5")); // hata
        } catch (HexFormatException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}   
