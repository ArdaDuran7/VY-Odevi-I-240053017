package RandevuSistemi;

/**
 * Hasta sınıfı, randevu takip sistemindeki her hastanın temel verilerini (data model) tutar.
 * Değişkenler: hastaID ,adSoyad ,randevuTarihi.
 */
public class Hasta {
    // Değişkenler
    private int hastaID;          // Hastanın benzersiz kimlik numarası (int)
    private String adSoyad;       // Hastanın adı ve soyadı (String)
    private String randevuTarihi; // Hastanın randevu tarihi (String, örn: "25.10.2025")

    /**
     * Hasta sınıfının Yapıcı Metodu (Constructor).
     * Bu üç değişkeni parametre olarak alıp atamalıdır.
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
     * Hastanın ID, Ad Soyad ve Randevu Tarihi bilgilerini ekrana yazdırır.
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