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

## 📁 Proje Yapısı (örnek)
