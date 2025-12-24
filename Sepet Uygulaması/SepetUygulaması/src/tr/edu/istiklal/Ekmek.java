package tr.edu.istiklal;

public class Ekmek extends Urun {
    private String ekmekTuru;
    private double gramaj;

    public Ekmek(String urunAdi, double fiyat, String ekmekTuru, double gramaj) {
        super("Ekmek", 15);
        this.ekmekTuru = ekmekTuru;
        this.gramaj = gramaj;
    }

    @Override
    public double kdvHesapla() {
        return fiyat;
    }
}
