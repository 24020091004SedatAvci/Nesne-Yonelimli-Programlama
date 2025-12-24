package Test;

import java.util.Scanner;
import tr.edu.istiklal.AyGunBilgi;

public class Test {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Ay numarasini giriniz (1-12): ");
        int ayNo = input.nextInt();

        AyGunBilgi bilgi = new AyGunBilgi();
        bilgi.HataYazdirma(ayNo);
    }
}

