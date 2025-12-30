# Mayın Tarlası (Minesweeper) - Java Swing

Bu repo, YouTube’daki “Mayın Tarlası” anlatımını takip ederek yaptığım **Java Swing tabanlı** klasik Mayın Tarlası oyununu içerir.  
Amaç: OOP mantığını, event (mouse click) yakalamayı ve basit GUI geliştirmeyi pratik etmek.

Video referansı: https://www.youtube.com/watch?v=ZKRgvEzq-2w

---

## 🎮 Oyun Mantığı
- Oyun **10x10** bir tahta üzerinde çalışır.
- Bazı hücrelerde mayın bulunur.
- Mayın olmayan hücre açıldığında, çevresindeki mayın sayısı gösterilir.
- Mayına basılırsa oyun biter.

---

## ✅ Özellikler
- 10x10 grid arayüz (Swing + GridLayout)
- Rastgele mayın yerleştirme
- Hücre açma / sayı gösterme
- Oyun bitiş kontrolü (mayına basma veya kazanma)
- Sağ tık ile bayrak koyma desteği *(projede varsa)*

> Not: Mayın sayısı / zorluk gibi değerler kod içinden değiştirilebilir (genelde `generateMine()` içinde).

---

## 🧰 Kullanılan Teknolojiler
- Java (JDK 8+ önerilir)
- Java Swing (GUI)
- OOP yapısı (Button sınıfı, listener’lar vs.)

---

## 🖼️ Uygulamadan Resimler
<img width="486" height="493" alt="1" src="https://github.com/user-attachments/assets/43692bdc-3fd1-49e5-a4ef-144964b23e3f" />
<img width="479" height="490" alt="4" src="https://github.com/user-attachments/assets/fde13098-1b95-476d-8435-6b63a523eb8c" />
<img width="486" height="493" alt="3" src="https://github.com/user-attachments/assets/142600c3-0a1d-4ef5-aefc-a65313b91884" />
<img width="486" height="493" alt="2" src="https://github.com/user-attachments/assets/3dd576ad-8d6d-47cf-8477-04674fabc7d8" />
