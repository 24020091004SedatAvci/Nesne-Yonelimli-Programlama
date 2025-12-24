package tr.edu.istiklal;

public abstract class Urun {
    protected String urunAdi;
    protected double fiyat;

    public Urun() {}

    public Urun(String urunAdi, double fiyat) {
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
    }

    public String getUrunAdi() { return urunAdi; }
    public double getFiyat() { return fiyat; }

    public void setUrunAdi(String urunAdi) { this.urunAdi = urunAdi; }
    public void setFiyat(double fiyat) { this.fiyat = fiyat; }

    public abstract double kdvHesapla();
}
