package Test;

import tr.edu.istiklal.ManuelKontrol;
import tr.edu.istiklal.Try_CatchKontrol;

public class Test {

    public static void main(String[] args) {

        ManuelKontrol m1 = new ManuelKontrol("+", "10", "5");
        System.out.println("10 + 5 = " + m1.HataYazdirma());

        ManuelKontrol m2 = new ManuelKontrol("*", "8", "3");
        System.out.println("8 * 3 = " + m2.HataYazdirma());

        System.out.println("\n=== Try-Catch ===");

        Try_CatchKontrol t1 = new Try_CatchKontrol("-", "20", "4");
        System.out.println("20 - 4 = " + t1.HataYazdirma());

        Try_CatchKontrol t2 = new Try_CatchKontrol("/", "6", "2");
        System.out.println("6 / 2 = " + t2.HataYazdirma());

        System.out.println("\n=== HATALI GIRIS TESTI ===");

        // Hatalı giriş testi
        Try_CatchKontrol t3 = new Try_CatchKontrol("+", "5", "a");
        t3.HataYazdirma();

        // Bu satır System.exit olduğu için çalışmaz
        System.out.println("Bu satır yazılmaz");
    }
}
