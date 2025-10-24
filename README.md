# VY-Odevi-I-OgrenciNumaraniz: Tek Yönlü Bağlı Liste ile Randevu Takip Sistemi

## 🎓 Öğrenci Bilgileri

| Alan | Bilgi |
| :--- | :--- |
| **Ad Soyad** Arda Duran |
| **Öğrenci Numarası** | 240053017 |

---

## 🎬 Video Sunum Linki

**Lütfen çektiğiniz 5-7 dakikalık tanıtım ve kod açıklama videosunun linkini buraya ekleyin.**
Bu link, YouTube (Liste Dışı/Unlisted) veya Google Drive (Herkese Açık) olmalıdır.

[Linkini çekince ekliyecem]

---

## 💡 Proje Hakkında Kısa Açıklama

Bu proje, Veri Yapıları dersi kapsamında, dinamik bellek yönetimi ve referans mantığını pekiştirmek amacıyla "Tek Yönlü Doğrusal Bağlı Liste" (Singly Linked List) veri yapısı kullanılarak geliştirilmiş basit bir randevu takip sistemidir. Sistem, acil durum hastalarını listenin başına, normal randevuları ise listenin sonuna ekleyebilme yeteneğine sahiptir.

---

## 🏗️ Çekirdek Sınıfların Yapısı ve Amacı

Projede, bağlı liste mantığını sıfırdan oluşturmak amacıyla Java'nın hazır kütüphaneleri kullanılmamıştır. Aşağıdaki sınıflar projeyi oluşturur:

1.  **`Hasta.java` (Veri Modeli Sınıfı)**
    * **Amaç:** Randevu sistemindeki her hastanın temel verilerini (hastalD, adSoyad, randevuTarihi) tutan veri modelini temsil eder.
    * **Metot:** Hastanın bilgilerini konsola yazdıran `bilgileriGoster()` metodunu içerir.

2.  **`Node.java` (Düğüm Sınıfı)**
    * **Amaç:** Bağlı listedeki her bir düğümü (elemanı) temsil eder.
    * **Yapı:** İki temel değişkeni vardır: `veri` (bir `Hasta` nesnesi) ve `sonraki` (listenin bir sonraki düğümünü işaret eden `Node` referansı).

3.  **`RandevuListesi.java` (Yönetici Sınıfı)**
    * **Amaç:** Tek Yönlü Bağlı Liste mantığını (head referansı) ve tüm temel liste algoritmalarını (ekleme, silme, arama, listeleme) içeren ana yönetim sınıfıdır.
    * **Temel Metotlar:**
        * `acilDurumEkle(Hasta hasta)`: Hastayı listenin **başına** ekler.
        * `randevuEkle(Hasta hasta)`: Hastayı listenin **sonuna** ekler.
        * `randevuiptal(int hastaID)`: Verilen ID'ye sahip hastayı listeden siler.
        * `randevuAra(int hastaID)`: Verilen ID'ye sahip hastayı listede arar.
        * `listeyiGoruntule()`: Listedeki tüm hastaları sırayla gösterir.

---

### 🚀 Çalıştırma ve Test

Proje, `Main.java` sınıfında oluşturulan `main` metodu ile test edilir. Bu metot; farklı senaryolarda (acil/normal ekleme, var olan/olmayan hastayı arama, baştan/ortadan/sondan silme) tüm `RandevuListesi` metotlarının doğru çalıştığını gösterir.