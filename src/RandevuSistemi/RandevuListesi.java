package RandevuSistemi;

/**
 * RandevuListesi sınıfı, Tek Yönlü Doğrusal Bağlı Liste (Singly Linked List) yapısını
 * kullanarak randevuları yöneten ana sınıftır.
 * Java'nın hazır LinkedList kütüphanesi kullanılmamıştır.
 */
public class RandevuListesi {
    // Değişkenler
    private Node head; // Listenin başını gösteren Node referansı

    /**
     * RandevuListesi sınıfının Yapıcı Metodu (Constructor).
     * Listenin başlangıçta boş olması için head referansını null olarak başlatır.
     */
    public RandevuListesi() {
        this.head = null;
    }

    /**
     * Yeni hastayı listenin başına ekler. Bu, Acil Durum hastaları için kullanılır.
     * Listenin başına ekleme işlemi O(1) karmaşıklığındadır.
     *
     * @param hasta Listeye eklenecek Hasta nesnesi.
     */
    public void acilDurumEkle(Hasta hasta) {
        // Yeni bir Node oluşturulur
        Node yeniNode = new Node(hasta);

        // 1. Yeni düğümün 'sonraki' referansı, listenin mevcut 'head'ini gösterecek şekilde ayarlanır.
        yeniNode.sonraki = head;

        // 2. Listenin 'head' referansı yeni düğümü gösterecek şekilde güncellenir.
        // Böylece yeni düğüm listenin ilk elemanı olur.
        head = yeniNode;

        System.out.println("[ACİL VAKA] Hasta ID: " + hasta.getHastaID() + " listede Öncelik Verildi.");
    }

    /**
     * Yeni hastayı listenin sonuna ekler (Normal randevu).
     * Listenin sonuna ekleme işlemi, listenin sonuna gitmek gerektiği için O(n) karmaşıklığındadır.
     *
     * @param hasta Listeye eklenecek Hasta nesnesi.
     */
    public void randevuEkle(Hasta hasta) {
        // Yeni bir Node oluşturulur
        Node yeniNode = new Node(hasta);

        // Liste boşsa (head null ise), yeni düğüm head olur.
        if (head == null) {
            head = yeniNode;
            System.out.println("[NORMAL VAKA] Hasta ID: " + hasta.getHastaID() + " listenin İLK hastası olarak eklendi.");
            return;
        }

        // Liste boş değilse, son düğümü bulmak için listenin başından başlanır.
        Node mevcut = head;
        // Mevcut düğümün 'sonraki' referansı null olana kadar ilerlenir (yani son düğüm bulunana kadar).
        while (mevcut.sonraki != null) {
            mevcut = mevcut.sonraki;
        }

        // Son düğüm bulunduğunda, onun 'sonraki' referansı yeni düğümü gösterecek şekilde ayarlanır.
        mevcut.sonraki = yeniNode;
        System.out.println("[NORMAL VAKA] Hasta ID: " + hasta.getHastaID() + " listenin SONUNA eklendi.");
    }

    /**
     * Verilen hastaID'ye sahip hastayı listede arar ve bilgilerini gösterir.
     *
     * @param hastaID Aranacak hastanın kimlik numarası.
     */
    public void randevuAra(int hastaID) {
        Node mevcut = head;
        int pozisyon = 1; // Arama başlangıç pozisyonu

        // Liste sonuna (null) ulaşana kadar döngü devam eder.
        while (mevcut != null) {
            // Mevcut düğümdeki Hasta nesnesinin ID'si, aranan ID ile eşleşiyor mu kontrol edilir.
            if (mevcut.veri.getHastaID() == hastaID) {
                System.out.println("\n[ARAMA BAŞARILI] Hasta ID: " + hastaID + " bulundu (Pozisyon: " + pozisyon + ")");
                mevcut.veri.bilgileriGoster(); // Hastanın bilgilerini gösterir.
                return; // Bulunduğu anda metottan çıkılır.
            }
            mevcut = mevcut.sonraki; // Sonraki düğüme geçilir.
            pozisyon++;
        }

        // Döngü biterse ve hasta bulunamazsa mesaj verilir.
        System.out.println("\n[ARAMA BAŞARISIZ] Hasta ID: " + hastaID + " bulunamadı.");
    }

    /**
     * Verilen hastaID'ye sahip hastayı listeden arar ve düğümü siler.
     * Silme işlemi için önceki düğümün referansını tutmak kritik öneme sahiptir.
     *
     * @param hastaID Silinecek hastanın kimlik numarası.
     */
    public void randevuiptal(int hastaID) {
        Node mevcut = head;
        Node onceki = null;

        // 1. Durum: Silinecek düğüm Listenin Başında (head) ise
        if (mevcut != null && mevcut.veri.getHastaID() == hastaID) {
            head = mevcut.sonraki; // head'i bir sonraki düğüme kaydırır.
            System.out.println("\n[İPTAL BAŞARILI] Hasta ID: " + hastaID + " listenin başından silindi.");
            return;
        }

        // 2. Durum: Silinecek düğüm Listenin Ortasında veya Sonunda ise
        // Silinecek düğümü bulmak için döngüde ilerlenir.
        // current null olana kadar (listenin sonuna kadar) veya ID eşleşene kadar ilerle.
        while (mevcut != null && mevcut.veri.getHastaID() != hastaID) {
            onceki = mevcut;        // mevcut'u kaybetmeden önce onceki olarak ata.
            mevcut = mevcut.sonraki; // mevcut'u bir sonraki düğüme taşı.
        }

        // 3. Durum: Eğer mevcut null değilse (yani aranan hasta bulundu)
        if (mevcut != null) {
            // önceki düğümün 'sonraki' referansını, mevcut düğümün 'sonraki' referansına bağlayarak
            // mevcut düğümü atlamış (bypass etmiş) ve listeden çıkarmış oluruz.
            onceki.sonraki = mevcut.sonraki;
            System.out.println("\n[İPTAL BAŞARILI] Hasta ID: " + hastaID + " listeden silindi.");
        }
        // 4. Durum: Eğer mevcut null ise (yani aranan hasta bulunamadı)
        else {
            System.out.println("\n[İPTAL BAŞARISIZ] Hasta bulunamadı. Hasta ID: " + hastaID + " listede bulunamadı.");
        }
    }

    /**
     * head'den başlayarak listenin sonuna kadar tüm hastaların bilgilerini sırayla ekrana yazdırır.
     */
    public void listeyiGoruntule() {
        Node mevcut = head;
        int sayac = 1;
        System.out.println("\n===== RANDEVU LİSTESİ GÖRÜNTÜLEME =====");

        // Liste boşsa mesaj verir.
        if (head == null) {
            System.out.println("Randevu listesinde hasta bulunamadı.");
            return;
        }

        // Listenin sonuna (null) ulaşana kadar tüm düğümleri dolaşır.
        while (mevcut != null) {
            System.out.println("--- " + sayac + ". Hasta ---");
            mevcut.veri.bilgileriGoster(); // Hasta sınıfının bilgileriGoster metodunu çağırır.
            mevcut = mevcut.sonraki; // Bir sonraki düğüme geçer.
            sayac++;
        }
        System.out.println("========================================\n");
    }
}