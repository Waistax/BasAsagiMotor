/**
 * başaşağıderebeyi.motor.Motor.java
 * 0.1 / 28 Ağu 2020 / 23:22:45
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.motor;

/** Motorun kalbi */
public class Motor {
	/** Sürüm */
	public static final String SÜRÜM = "0.7";
	/** Uygulamanın kare süreci */
	public static final Süreç UYGULAMA_SÜRECİ = new Süreç();
	/** Girdinin kare süreci */
	public static final Süreç GİRDİ_SÜRECİ = new Süreç();
	/** Görselleştiricinin gösterme süreci */
	public static final Süreç GÖSTERME_SÜRECİ = new Süreç();
	/** Aktif görselleştirici
	 * Bu değişken motor başladıktan sonra sabit kalmalıdır. */
	public static Görselleştirici görselleştirici;
	/** Aktif uygulama
	 * Bu değişken motor başladıktan sonra sabit kalmalıdır. */
	public static Uygulama uygulama;
	/** Hedeflenen saniye başına kare oranı.
	 * Eğer bu değer sıfır ise motor elinden geldiğince hızlı çalışır. */
	public static float hedefKareOranı;
	/** Motorun çalıştığını gösteren bayrak */
	public static boolean çalışmakta;
	/** Anlık saniye başına kare sayısı */
	public static float kareOranı;
	/** İşlenmeyi bekleyen kare sayısı */
	public static float işlenmemişKareler;

	/** Şuanki zamanı nano saniye cinsinden verir */
	public static float zaman() {
		return (float)System.nanoTime();
	}

	/** Motoru başlatır */
	public static void başla() {
		// Eğer motor zaten çalışıyorsa
		if (çalışmakta)
			// Motoru tekrar başlatma
			return;
		// Ana döngüyü çalıştır
		çalışmakta = true;
		çalış();
	}
	
	/** Motoru durdur */
	public static void dur() {
/*		// Eğer motor zaten çalışmıyorsa
		if (!çalışmakta)
			// Motoru tekrar durdurma
			return;
		Bu kontrol gereksiz. */
		çalışmakta = false;
	}
	
	/** Ana döngüyü çalıştırır */
	public static void çalış() {
		try {
			// Yükle
			görselleştirici.oluştur();
			uygulama.yükle();
			// Ana döngüyü başlat
			float öncekiZaman = zaman();
			float saniyeSayacı = 0.0F;
			int kareler = 0;
			while (çalışmakta) {
				// Geçen zamanı hesapla
				float geçenZaman = zaman() - öncekiZaman;
				öncekiZaman += geçenZaman;
				// Bu kısımdan sonra geçen zaman saniye cinsinden
				geçenZaman /= 1000000000.0F;
				if (hedefKareOranı == 0.0F) {
					kare();
					kareler++;
					işlenmemişKareler = 0.0F;
				} else {
					for (işlenmemişKareler += geçenZaman * hedefKareOranı;
							işlenmemişKareler >= 1.0F;işlenmemişKareler--, kareler++)
						kare();
				}
				// Her saniyede bir
				if ((saniyeSayacı += geçenZaman) >= 1.0F) {
					// Kare oranını hesapla
					kareOranı = kareler / saniyeSayacı;
					UYGULAMA_SÜRECİ.hesapla();
					GİRDİ_SÜRECİ.hesapla();
					GÖSTERME_SÜRECİ.hesapla();
					// Süreçleri yazdır
					System.out.println("Kare Oranı: " + kareOranı);
					System.out.println("Uygulama: " + UYGULAMA_SÜRECİ.ortalamayıAl() + "ms");
					System.out.println("Girdi: " + GİRDİ_SÜRECİ.ortalamayıAl() + "ms");
					System.out.println("Gösterme: " + GÖSTERME_SÜRECİ.ortalamayıAl() + "ms");
					// Sıfırla
					kareler = 0;
					saniyeSayacı--;
					uygulama.saniye();
				}
				// Dizüstümün yükünü bitirmemek için
				Thread.sleep(5);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Temizle
			görselleştirici.yokEt();
			// Kaydet
			uygulama.kaydet();
			System.exit(0);
		}
	}
	
	/** Kareyi işler */
	private static void kare() {
		GİRDİ_SÜRECİ.başla();
		görselleştirici.girdiyiAl().kare();
		GİRDİ_SÜRECİ.dur();
		UYGULAMA_SÜRECİ.başla();
		uygulama.kare();
		UYGULAMA_SÜRECİ.dur();
		GÖSTERME_SÜRECİ.başla();
		görselleştirici.göster();
		GÖSTERME_SÜRECİ.dur();
	}
	
	/** Gizli tanımlayıcı
	 * Bu sınıfın bir nesnesini oluşturmayı engeller. */
	private Motor() {}
}
