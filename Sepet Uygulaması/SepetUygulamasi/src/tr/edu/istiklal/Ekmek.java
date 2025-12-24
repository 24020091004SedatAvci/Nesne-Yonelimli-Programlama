package tr.edu.istiklal;

public class Ekmek extends Urun {
    private String ekmekTuru;
    private double gramaj;

    public Ekmek() {}

    public Ekmek(String urunAdi, double fiyat, String ekmekTuru, double gramaj) {
        super(urunAdi, fiyat);       // <-- SABİT DEĞİL
        this.ekmekTuru = ekmekTuru;
        this.gramaj = gramaj;
    }

    public String getEkmekTuru() { return ekmekTuru; }
    public double getGramaj() { return gramaj; }

    public void setEkmekTuru(String ekmekTuru) { this.ekmekTuru = ekmekTuru; }
    public void setGramaj(double gramaj) { this.gramaj = gramaj; }

    @Override
    public double kdvHesapla() {
        return fiyat; // ekmekte KDV yok gibi (senin mantığın)
    }
}
