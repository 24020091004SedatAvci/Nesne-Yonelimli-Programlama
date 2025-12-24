package tr.edu.istiklal;

public class Tekstil extends Urun {
    private String kumasTuru;
    private int beden;
    private String ureticiFirma;

    public Tekstil() {}

    public Tekstil(String urunAdi, double fiyat, String kumasTuru, int beden, String ureticiFirma) {
        super(urunAdi, fiyat);      // <-- SABİT DEĞİL
        this.kumasTuru = kumasTuru;
        this.beden = beden;
        this.ureticiFirma = ureticiFirma;
    }

    public String getKumasTuru() { return kumasTuru; }
    public int getBeden() { return beden; }
    public String getUreticiFirma() { return ureticiFirma; }

    public void setKumasTuru(String kumasTuru) { this.kumasTuru = kumasTuru; }
    public void setBeden(int beden) { this.beden = beden; }
    public void setUreticiFirma(String ureticiFirma) { this.ureticiFirma = ureticiFirma; }

    @Override
    public double kdvHesapla() {
        return fiyat * 1.10;
    }
}
