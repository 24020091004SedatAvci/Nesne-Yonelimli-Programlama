package tr.edu.istiklal;

public class BinaryFormatException extends Exception {
    public BinaryFormatException() {
        super("Hata: Girilen değer ikili (binary) sayı değildir. Sadece 0 ve 1 olmalıdır.");
    }
}
