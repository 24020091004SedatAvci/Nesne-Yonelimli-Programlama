
package tr.edu.istiklal;


public class AyGunBilgi {
    private static String[] aylar = {
        "Ocak", "Subat", "Mart", "Nisan",
        "Mayis", "Haziran", "Temmuz", "Agustos",
        "Eylul", "Ekim", "Kasim", "Aralik"
    };

    private static int[] gunSayilari = {
        31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };

    public void HataYazdirma(int ayNo) {

        try {
            // Kullanıcı 1–12 giriyor, dizi 0–11
            System.out.println(getAylar()[ayNo - 1] + " ayi " +
                getGunSayilari()[ayNo - 1] + " gun ceker."
            );

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Yanlis ay sayisi");
        }
    }

    /**
     * @return the aylar
     */
    public static String[] getAylar() {
        return aylar;
    }

    /**
     * @param aAylar the aylar to set
     */
    public static void setAylar(String[] aAylar) {
        aylar = aAylar;
    }

    /**
     * @return the gunSayilari
     */
    public static int[] getGunSayilari() {
        return gunSayilari;
    }

    /**
     * @param aGunSayilari the gunSayilari to set
     */
    public static void setGunSayilari(int[] aGunSayilari) {
        gunSayilari = aGunSayilari;
    }
    

};

