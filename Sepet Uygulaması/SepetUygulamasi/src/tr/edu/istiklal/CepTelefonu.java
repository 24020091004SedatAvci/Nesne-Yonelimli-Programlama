package tr.edu.istiklal;

public class CepTelefonu extends Urun {
    private String marka;
    private String model;

    public CepTelefonu() {}

    public CepTelefonu(String urunAdi, double fiyat, String marka, String model) {
        super(urunAdi, fiyat);        // <-- SABİT DEĞİL, PARAMETRE!
        this.marka = marka;
        this.model = model;
    }

    public String getMarka() { return marka; }
    public String getModel() { return model; }

    public void setMarka(String marka) { this.marka = marka; }
    public void setModel(String model) { this.model = model; }

    @Override
    public double kdvHesapla() {
        return fiyat * 1.18;
    }
}
