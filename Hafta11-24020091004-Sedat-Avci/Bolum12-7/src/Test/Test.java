
package Test;
import tr.edu.istiklal.Fraction;
import tr.edu.istiklal.NullDenominatorException;
public class Test {
    public static void main(String[] args) {

        try {
            Fraction f1 = new Fraction(3, 0);
        } catch (NullDenominatorException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}


