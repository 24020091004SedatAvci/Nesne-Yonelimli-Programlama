package test;

import tr.edu.istiklal.Fraction;
import tr.edu.istiklal.NullDenominatorException;

public class TestFraction {
    public static void main(String[] args) {
        try {
            Fraction f1 = new Fraction(6, 8);
            System.out.println(f1);

            Fraction f2 = new Fraction(5, 0); 
            System.out.println(f2);
        } catch (NullDenominatorException e) {
            System.out.println("Hata yakalandi: " + e.getMessage());
        }
    }
}
