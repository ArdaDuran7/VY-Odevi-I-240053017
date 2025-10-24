package RandevuSistemi;

/**
 * Hasta sınıfı, randevu takip sistemindeki her hastanın temel verilerini (data model) tutar.
 * Değişkenler: hastaID [cite: 39], adSoyad [cite: 39], randevuTarihi[cite: 39].
 */
public class Hasta {
    // Değişkenler
    private int hastaID;          // Hastanın benzersiz kimlik numarası (int) [cite: 39]
    private String adSoyad;       // Hastanın adı ve soyadı (String) [cite: 39]
    private String randevuTarihi; // Hastanın randevu tarihi (String, örn: "25.10.2025") [cite: 39]

    /**
     * Hasta sınıfının Yapıcı Metodu (Constructor).
     * Bu üç değişkeni parametre olarak alıp atamalıdır[cite: 42].
     *
     * @param hastaID Benzersiz hasta kimliği.
     * @param adSoyad Hastanın adı ve soyadı.
     * @param randevuTarihi Randevu tarihi.
     */
    public Hasta(int hastaID, String adSoyad, String randevuTarihi) {
        this.hastaID = hastaID;
        this.adSoyad = adSoyad;
        this.randevuTarihi = randevuTarihi;
    }

    /**
     * Hastanın ID, Ad Soyad ve Randevu Tarihi bilgilerini ekrana yazdırır[cite: 43].
     * Konsol çıktısında anlaşılır bir formatta görüntüleme sağlar.
     */
    public void bilgileriGoster() {
        System.out.println("----------------------------------------");
        System.out.println("Hasta ID: " + hastaID);
        System.out.println("Ad Soyad: " + adSoyad);
        System.out.println("Randevu Tarihi: " + randevuTarihi);
        System.out.println("----------------------------------------");
    }

    /**
     * Hastanın ID'sini döndürür.
     * @return Hastanın benzersiz ID'si (int).
     */
    public int getHastaID() {
        return hastaID;
    }
}