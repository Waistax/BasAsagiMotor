/**
 * başaşağıderebeyi.motor.Motor.java
 * 0.1 / 28 Ağu 2020 / 23:22:45
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.motor;

public class Motor {
	public static final String SÜRÜM = "0.13";
	public static final Süreç UYGULAMA_SÜRECİ = new Süreç();
	public static final Süreç GİRDİ_SÜRECİ = new Süreç();
	public static final Süreç GÖSTERME_SÜRECİ = new Süreç();
	
	public static Görselleştirici görselleştirici;
	public static Uygulama uygulama;
	public static float hedefKareOranı;
	public static boolean çalışmakta;
	public static float kareOranı;
	public static float işlenmemişKareler;
	
	public static float zaman() {
		return (float)System.nanoTime();
	}
	
	public static void başla() {
		if (çalışmakta)
			return;
		çalışmakta = true;
		çalış();
	}
	
	public static void dur() {
		çalışmakta = false;
	}
	
	public static void çalış() {
		try {
			görselleştirici.oluştur();
			uygulama.yükle();
			float öncekiZaman = zaman();
			float saniyeSayacı = 0.0F;
			int kareler = 0;
			while (çalışmakta) {
				float geçenZaman = zaman() - öncekiZaman;
				öncekiZaman += geçenZaman;
				geçenZaman /= 1000000000.0F;
				if (hedefKareOranı == 0.0F) {
					kare();
					kareler++;
					işlenmemişKareler = 0.0F;
				} else
					for (işlenmemişKareler += geçenZaman * hedefKareOranı; işlenmemişKareler >= 1.0F; işlenmemişKareler--, kareler++)
						kare();
				if ((saniyeSayacı += geçenZaman) >= 1.0F) {
					kareOranı = kareler / saniyeSayacı;
					UYGULAMA_SÜRECİ.hesapla();
					GİRDİ_SÜRECİ.hesapla();
					GÖSTERME_SÜRECİ.hesapla();
					kareler = 0;
					saniyeSayacı--;
					uygulama.saniye();
				}
				Thread.sleep(5);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			görselleştirici.yokEt();
			uygulama.kaydet();
			System.exit(0);
		}
	}
	
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
	
	private Motor() {
	}
}
