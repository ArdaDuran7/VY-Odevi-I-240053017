package RandevuSistemi;

/**
 * Node (Düğüm) sınıfı, tek yönlü bağlı listedeki her bir elemanı temsil eder.
 * Bir veri nesnesi (Hasta) ve listenin bir sonraki elemanına (Node) referans tutar.
 */
public class Node {
    // Değişkenler
    public Hasta veri;      // Düğümün taşıdığı veri (bir Hasta nesnesi tutmalıdır)
    public Node sonraki;    // Listenin bir sonraki elemanını referans eden işaretçi (Node nesnesi)

    /**
     * Node sınıfının Yapıcı Metodu (Constructor).
     *
     * @param hasta Parametre olarak bir Hasta nesnesi alır.
     */
    public Node(Hasta hasta) {
        this.veri = hasta; // Gelen Hasta nesnesini veri değişkenine atar.
        this.sonraki = null; // Başlangıçta sonraki referansını null yapar (Listenin sonu).
    }
}