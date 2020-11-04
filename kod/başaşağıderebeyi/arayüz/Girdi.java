/**
 * başaşağıderebeyi.arayüz.Girdi.java
 * 0.4 / 29 Ağu 2020 / 00:26:39
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

import başaşağıderebeyi.matematik.*;

import java.util.*;

public class Girdi {
	public static final Map<Integer, Tuş> TUŞLAR = new HashMap<>();
	public static final Vektör2 İMLEÇ = new Vektör2();
	public static final Vektör2 SÜRÜKLEME = new Vektör2();
	private static final Vektör2 İMLEÇ_GİRDİSİ = new Vektör2();

	public static int tekerlek;
	private static volatile int tekerlekGirdisi;
	public static Öğe imleçHedefi;
	public static Öğe tekerlekHedefi;
	
	public static void güncelle() {
		synchronized (Girdi.class) {
			tekerlek = tekerlekGirdisi;
			tekerlekGirdisi = 0;
		}
		synchronized(İMLEÇ_GİRDİSİ) {
			SÜRÜKLEME.çıkar(İMLEÇ_GİRDİSİ, İMLEÇ);
			İMLEÇ.yaz(İMLEÇ_GİRDİSİ);
		}
		synchronized (TUŞLAR) {
			for (Tuş tuş : TUŞLAR.values())
				tuş.güncelle();
		}
	}
	
	public static void tuşOluştur(int kod) {
		synchronized (TUŞLAR) {
			if (!TUŞLAR.containsKey(kod))
				TUŞLAR.put(kod, new Tuş(kod));
		} 
	}
	
	public static void fareTuşuOluştur(int kod) {
		tuşOluştur(-kod);
	}
	
	public static Tuş tuşAl(int kod) {
		synchronized (TUŞLAR) {
			return TUŞLAR.get(kod);
		}
	}
	
	public static Tuş fareTuşuAl(int kod) {
		return tuşAl(-kod);
	}
	
	public static void girdiYaz(int kod, boolean girdi) {
		Tuş tuş = tuşAl(kod);
		if (tuş != null)
			tuş.girdi = girdi;
	}
	
	public static void fareGirdisiYaz(int kod, boolean girdi) {
		girdiYaz(-kod, girdi);
	}
	
	public static void imleçGirdisiYaz(float x, float y) {
		synchronized (İMLEÇ_GİRDİSİ) {
			İMLEÇ_GİRDİSİ.yaz(x, y);
		}
	}
	
	public static void tekerlekGirdisiYaz(int dönme) {
		synchronized (Girdi.class) {
			tekerlekGirdisi += dönme;
		}
	}
	
	public static boolean imleçBoştaMı() {
		return imleçHedefi == null;
	}
	
	public static boolean imleçUygunMu(Öğe hedef) {
		return imleçBoştaMı() || imleçHedefi == hedef;
	}
	
	public static void imleçKullanıldı(Öğe hedef) {
		imleçHedefi = hedef;
	}
	
	public static void imleçBoşta() {
		imleçKullanıldı(null);
	}
	
	public static boolean tekerlekBoştaMı() {
		return tekerlekHedefi == null;
	}
	
	public static boolean tekerlekUygunMu(Öğe hedef) {
		return tekerlekBoştaMı() || tekerlekHedefi == hedef;
	}
	
	public static void tekerlekKullanıldı(Öğe hedef) {
		tekerlekHedefi = hedef;
	}
	
	public static void tekerlekBoşta() {
		tekerlekKullanıldı(null);
	}
}
