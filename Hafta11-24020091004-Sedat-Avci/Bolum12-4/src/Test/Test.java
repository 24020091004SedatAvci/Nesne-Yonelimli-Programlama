package Test;
import tr.edu.istiklal.Loan;

public class Test {
    public static void main(String[] args) {

        try {
            Loan loan = new Loan(5.5, 0, 10000); // hata verir
        } catch (IllegalArgumentException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}

