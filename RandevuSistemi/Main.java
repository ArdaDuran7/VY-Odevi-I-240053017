package RandevuSistemi;
/**
 * Main sınıfı, Randevu Takip Sistemi'nin temel işlevlerini (ekleme, silme, arama)
 * test etmek için kullanılır.
 */
public class Main {
    public static void main(String[] args) {
        // RandevuListesi nesnesi oluşturulur.
        RandevuListesi liste = new RandevuListesi();

        // Örnek Hasta nesneleri oluşturulur.
        Hasta h1 = new Hasta(101, "Ali Yılmaz", "26.10.2025");
        Hasta h2 = new Hasta(102, "Ayşe Kaya", "27.10.2025");
        Hasta h3 = new Hasta(103, "Mehmet Öztürk", "28.10.2025");
        Hasta h4 = new Hasta(201, "Gizem Demirci", "24.10.2025"); // Acil Durum hastası

        // --- 1. Ekleme İşlemleri ---
        System.out.println("--- EKLEME İŞLEMLERİ ---");
        // Normal randevular listenin sonuna eklenir (randevuEkle).
        liste.randevuEkle(h1); // Son (Head = 101)
        liste.randevuEkle(h2); // Sonraki (101 -> 102)

        // Acil durum randevusu listenin başına eklenir (acilDurumEkle).
        liste.acilDurumEkle(h4); // Baş (201 -> 101 -> 102)

        liste.randevuEkle(h3); // Sonraki (201 -> 101 -> 102 -> 103)

        // --- 2. Listeyi Görüntüleme ---
        // Liste: 201 -> 101 -> 102 -> 103
        System.out.println("\n--- İLK LİSTE GÖRÜNTÜSÜ (Acil Hasta Başa Geldi) ---");
        liste.listeyiGoruntule();

        // --- 3. Arama İşlemleri ---
        System.out.println("\n--- ARAMA İŞLEMLERİ ---");
        // Var olan bir hastayı arama
        liste.randevuAra(102); // Başarılı arama beklenir.

        // Olmayan bir hastayı arama
        liste.randevuAra(100); // Başarısız arama beklenir.

        // --- 4. Silme İşlemleri ---
        System.out.println("\n--- SİLME İŞLEMLERİ ---");

        // Başlangıçtaki hastayı silme (201 - Acil Hasta)
        liste.randevuiptal(201);

        // Silme sonrası listeyi görüntüleme
        System.out.println("\n--- SİLME SONRASI LİSTE GÖRÜNTÜSÜ (201 Silindi) ---");
        liste.listeyiGoruntule(); // Liste: 101 -> 102 -> 103 (Baş 101 oldu)

        // Ortadaki bir hastayı silme (102)
        liste.randevuiptal(102);

        // Silme sonrası listeyi görüntüleme
        System.out.println("\n--- SİLME SONRASI LİSTE GÖRÜNTÜSÜ (102 Silindi) ---");
        liste.listeyiGoruntule(); // Liste: 101 -> 103

        // Olmayan bir hastayı silmeye çalışma
        liste.randevuiptal(100); // Başarısız silme beklenir.

        // Sondaki hastayı silme (103)
        liste.randevuiptal(103);

        // Silme sonrası listeyi görüntüleme
        System.out.println("\n--- SİLME SONRASI LİSTE GÖRÜNTÜSÜ (103 Silindi) ---");
        liste.listeyiGoruntule(); // Liste: 101

        // Kalan tek hastayı silme (101)
        liste.randevuiptal(101);

        // Son silme sonrası listeyi görüntüleme (Liste Boş Olmalı)
        System.out.println("\n--- SİLME SONRASI LİSTE GÖRÜNTÜSÜ (101 Silindi, Liste Boş) ---");
        liste.listeyiGoruntule(); // Liste Boş
    }
}