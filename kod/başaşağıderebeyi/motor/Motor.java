/**
 * başaşağıderebeyi.motor.Motor.java
 * 0.1 / 28 Ağu 2020 / 23:22:45
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.motor;

import başaşağıderebeyi.girdi.*;

import java.util.concurrent.*;

public class Motor {
	public static final String SÜRÜM = "0.26";
	public static final Süreç GÜNCELLEME_SÜRECİ = new Süreç();
	public static final Süreç ÇİZME_SÜRECİ = new Süreç();
	
	public static int yürütücüİşlemSayısı;
	public static ExecutorService yürütücü;
	public static Görselleştirici görselleştirici;
	public static Uygulama uygulama;
	public static float hedefTıkOranı;
	public static volatile boolean çalışmakta;
	public static int tıkOranı;
	public static int kareOranı;
	public static float işlenmemişTıklar;
	
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
			yürütücüİşlemSayısı = Runtime.getRuntime().availableProcessors() - 1;
			yürütücü = Executors.newFixedThreadPool(yürütücüİşlemSayısı);
			görselleştirici.oluştur();
			uygulama.yükle();
			float öncekiZaman = zaman();
			float saniyeSayacı = 0.0F;
			int tıklar = 0;
			int kareler = 0;
			while (çalışmakta) {
				float geçenZaman = zaman() - öncekiZaman;
				öncekiZaman += geçenZaman;
				geçenZaman /= 1000000000.0F;
				if (hedefTıkOranı == 0.0F) {
					tıklar++;
					güncelle();
					işlenmemişTıklar = 0.0F;
				} else
					for (işlenmemişTıklar += geçenZaman * hedefTıkOranı; işlenmemişTıklar >= 1.0F; işlenmemişTıklar--, tıklar++)
						güncelle();
				çiz();
				kareler++;
				if ((saniyeSayacı += geçenZaman) >= 1.0F) {
					tıkOranı = tıklar;
					kareOranı = kareler;
					GÜNCELLEME_SÜRECİ.hesapla();
					ÇİZME_SÜRECİ.hesapla();
					tıklar = 0;
					kareler = 0;
					saniyeSayacı--;
					uygulama.saniye();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			görselleştirici.yokEt();
			uygulama.kaydet();
			yürütücü.shutdown();
			try {
				yürütücü.awaitTermination(1, TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.exit(0);
		}
	}
	
	private static void güncelle() {
		GÜNCELLEME_SÜRECİ.başla();
		Girdi.güncelle();
		uygulama.güncelle();
		GÜNCELLEME_SÜRECİ.dur();
	}
	
	private static void çiz() {
		ÇİZME_SÜRECİ.başla();
		uygulama.çiz();
		görselleştirici.göster();
		ÇİZME_SÜRECİ.dur();
	}
	
	private Motor() {
	}
}
