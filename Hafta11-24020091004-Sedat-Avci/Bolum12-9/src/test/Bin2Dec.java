package test;
import tr.edu.istiklal.BinaryFormatException;
import java.util.Scanner;

public class Bin2Dec {

    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if (c != '0' && c != '1') {
                throw new BinaryFormatException();
            }
        }

        int sonuc = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            sonuc = sonuc * 2 + (binaryString.charAt(i) - '0');
        }
        return sonuc;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Binary sayi gir: ");
        String s = input.nextLine();

        try {
            System.out.println("Ondalik karsiligi: " + bin2Dec(s));
        } catch (BinaryFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
