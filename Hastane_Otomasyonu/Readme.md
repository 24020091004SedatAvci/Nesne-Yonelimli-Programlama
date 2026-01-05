🏥 Hastane Yönetim Sistemi (Hospital Management System)
Bu proje, Java Swing arayüz kütüphanesi ve MySQL/MariaDB veritabanı kullanılarak geliştirilmiş kapsamlı bir hastane otomasyon sistemidir. Proje, MVC (Model-View-Controller) mimari yapısına uygun olarak tasarlanmıştır.

🚀 Özellikler
Sistem üç farklı kullanıcı tipi için özelleştirilmiş paneller sunar:

0- Giriş Paneli
-Hasta ve Doktorların giriş yapacağı panledir.

<img width="486" height="393" alt="Ekran görüntüsü 2026-01-05 104429" src="https://github.com/user-attachments/assets/94d3fcfe-7780-4bb3-a631-1fe65f4c20bd" />

1- 👨‍⚕️ Başhekim (Admin) Paneli
-Doktor Yönetimi: Sisteme yeni doktor ekleme, silme ve bilgilerini güncelleme.
-Poliklinik Yönetimi: Yeni poliklinik oluşturma ve düzenleme.
-Çalışan Atama: Doktorları ilgili polikliniklere atama işlemleri.

<img width="736" height="493" alt="Ekran görüntüsü 2026-01-05 105222" src="https://github.com/user-attachments/assets/55cc0fdb-2fb3-4cac-bc6d-d963fec515da" />

2- 🩺 Doktor Paneli
Çalışma Saati Yönetimi: Doktorlar kendi uygunluk durumlarına göre takvimden tarih ve saat seçerek randevu açabilirler.
Randevu Görüntüleme: Kendisine alınan randevuları listeleme.

<img width="736" height="493" alt="Ekran görüntüsü 2026-01-05 105237" src="https://github.com/user-attachments/assets/662b4cd8-3d17-48cf-a36f-1c14917d8d82" />

3- 👤 Hasta Paneli
Kayıt ve Giriş: Hastalar T.C. kimlik numaraları ile sisteme kayıt olup giriş yapabilirler.
Randevu Alma: Poliklinik ve doktor seçimi yaparak uygun saatlere randevu oluşturma.
Randevu Takibi: Alınan aktif randevuları görüntüleme.

<img width="736" height="493" alt="Ekran görüntüsü 2026-01-05 105306" src="https://github.com/user-attachments/assets/644f2496-ae67-401b-8445-e8245f968631" />
<img width="736" height="493" alt="Ekran görüntüsü 2026-01-05 105255" src="https://github.com/user-attachments/assets/2e101fbb-1245-4f89-8b09-376ba470ab5e" />

🛠️ Kullanılan Teknolojiler
Dil: Java (JDK 17+)
Arayüz (GUI): Java Swing & AWT
Veritabanı: MySQL veya MariaDB
Veritabanı Bağlantısı: JDBC (Java Database Connectivity)
Tasarım Deseni: MVC (Model-View-Controller)

⚙️ Kurulum ve Çalıştırma
Projeyi kendi bilgisayarınızda çalıştırmak için aşağıdaki adımları izleyin:
Projeyi İndirin: Bu repoyu bilgisayarınıza klonlayın veya ZIP olarak indirin.
Veritabanını Oluşturun: MySQL veya HeidiSQL üzerinde hastane adında bir veritabanı oluşturun ve aşağıdaki SQL kodlarını çalıştırarak tabloları oluşturun:

SQL
-- Kullanıcı Tablosu
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tcno` varchar(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` enum('bashekim','doktor','hasta') NOT NULL DEFAULT 'hasta',
  PRIMARY KEY (`id`)
);

-- Poliklinik Tablosu
-CREATE TABLE `clinic` (
-  `id` int(11) NOT NULL AUTO_INCREMENT,
-  `name` varchar(255) NOT NULL,
-  PRIMARY KEY (`id`)
);

-- Randevu (Appointment) Tablosu
-CREATE TABLE `appointment` (
-  `id` int(11) NOT NULL AUTO_INCREMENT,
-  `doctor_id` int(11) NOT NULL,
-  `doctor_name` varchar(255) DEFAULT NULL,
-  `hasta_id` int(11) NOT NULL,
-  `hasta_name` varchar(255) DEFAULT NULL,
-  `app_date` varchar(255) DEFAULT NULL,
-  PRIMARY KEY (`id`)
);

-- Çalışma Saatleri (Whour) Tablosu
-CREATE TABLE `whour` (
-  `id` int(11) NOT NULL AUTO_INCREMENT,
-  `doctor_id` int(11) NOT NULL,
-  `doctor_name` varchar(255) DEFAULT NULL,
-  `wdate` varchar(255) DEFAULT NULL,
-  `status` enum('a','p') DEFAULT 'a',
-  PRIMARY KEY (`id`)
);
-Veritabanı Bağlantısını Yapılandırın: Helper paketi altındaki DBConnection.java dosyasını açın ve kendi veritabanı bilgilerinizi girin:

Java

static final String DB_URL = "jdbc:mysql://localhost/hastane";
static final String USER = "root"; // Kendi veritabanı kullanıcı adınız
static final String PASS = "";     // Kendi şifreniz
Projeyi Başlatın: View paketi altındaki LoginGUI.java dosyasına sağ tıklayıp Run diyerek uygulamayı başlatın.

📝 Varsayılan Giriş Bilgileri
Sistemi test etmek için veritabanına manuel olarak bir Başhekim ekleyebilirsiniz:

Tip: basHekim
TC No: (Veritabanına eklediğiniz değer)
Şifre: (Veritabanına eklediğiniz değer)
