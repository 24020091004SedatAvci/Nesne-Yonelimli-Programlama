# Sepet Uygulaması (Java JFrameForm)

Basit bir “internet alışveriş sepeti” mantığıyla çalışan Java Swing masaüstü uygulaması.  
Kategorilerden (Ekmek / Telefon / Tekstil) ürün seçip sepete ekleyebilir, sepetten silebilir ve sepeti temizleyebilirsiniz.  
Ara toplam, KDV ve KDV’li toplam otomatik hesaplanır.

## Özellikler
- Kategori bazlı ürün listeleri (JTabbedPane)
- Sepete ürün ekleme / silme / temizleme
- Ara Toplam, KDV, KDV’li Toplam hesaplama
- TableModel (DefaultTableModel) ile tablo yönetimi

## Kullanılan Sınıflar
- `Urun` (abstract)
- `Ekmek`, `CepTelefonu`, `Tekstil` (Urun’dan türeyen ürünler)
- `Sepet` (ürün listesini tutar, toplamları hesaplar)
- `SepetFrame` (Swing arayüz + event handler’lar)


