package tr.edu.istiklal;

public abstract class Urun {
    protected String urunAdi;
    protected double fiyat;

    public Urun() {
    }

    public Urun(String urunAdi, double fiyat) {
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
    }

    public double getFiyat() {
        return fiyat;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public abstract double kdvHesapla();
}
