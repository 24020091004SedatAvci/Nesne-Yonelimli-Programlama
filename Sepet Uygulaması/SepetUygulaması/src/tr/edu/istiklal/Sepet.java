package tr.edu.istiklal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sepet {
    private final List<Urun> urunler = new ArrayList<>();

    public void ekle(Urun u) { urunler.add(u); }

    public void sil(int index) {
        if (index >= 0 && index < urunler.size()) urunler.remove(index);
    }

    public void temizle() { urunler.clear(); }

    public List<Urun> getUrunler() {
        return Collections.unmodifiableList(urunler);
    }

    public double araToplam() {
        double t = 0;
        for (Urun u : urunler) t += u.getFiyat();
        return t;
    }

    public double kdvliToplam() {
        double t = 0;
        for (Urun u : urunler) t += u.kdvHesapla();
        return t;
    }

    public double toplamKdvTutari() {
        return kdvliToplam() - araToplam();
    }
}
