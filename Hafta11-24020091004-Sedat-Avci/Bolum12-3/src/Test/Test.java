package Test;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Test {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int sayi = 0;
        boolean dogruMu = false;

        while (!dogruMu) {
            try {
                System.out.print("Bir tamsayi giriniz: ");
                sayi = input.nextInt();   // sadece int kabul eder
                dogruMu = true;           // buraya gelirse sorun yok
            } catch (InputMismatchException e) {
                System.out.println("Hata! Lutfen sadece tamsayi giriniz.");
                input.next(); // hatalı girişi temizler
            }
        }

        System.out.println("Girdiginiz sayi: " + sayi);
    }
}

