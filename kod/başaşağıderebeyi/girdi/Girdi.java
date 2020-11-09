/**
 * başaşağıderebeyi.girdi.Girdi.java
 * 0.4 / 29 Ağu 2020 / 00:26:39
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.girdi;

import başaşağıderebeyi.matematik.*;

import java.util.*;

public class Girdi {
	public static final Map<Integer, Tuş> TUŞLAR = new HashMap<>();
	public static final Vektör2 İMLEÇ = new Vektör2();
	public static final Vektör2 SÜRÜKLEME = new Vektör2();
	private static final Vektör2 İMLEÇ_GİRDİSİ = new Vektör2();

	public static int tekerlek;
	private static int tekerlekGirdisi;
	public static Object imleçHedefi;
	public static Object tekerlekHedefi;
	
	public static synchronized void güncelle() {
		tekerlek = tekerlekGirdisi;
		tekerlekGirdisi = 0;
		SÜRÜKLEME.çıkar(İMLEÇ_GİRDİSİ, İMLEÇ);
		İMLEÇ.yaz(İMLEÇ_GİRDİSİ);
		for (Tuş tuş : TUŞLAR.values())
			tuş.güncelle();
	}
	
	public static synchronized void tuşOluştur(int kod) {
		if (!TUŞLAR.containsKey(kod))
			TUŞLAR.put(kod, new Tuş(kod));
	}
	
	public static synchronized void fareTuşuOluştur(int kod) {
		tuşOluştur(-kod);
	}
	
	public static synchronized Tuş tuşAl(int kod) {
		return TUŞLAR.get(kod);
	}
	
	public static synchronized Tuş fareTuşuAl(int kod) {
		return tuşAl(-kod);
	}
	
	public static synchronized void girdiYaz(int kod, boolean girdi) {
		Tuş tuş = tuşAl(kod);
		if (tuş != null)
			tuş.girdi = girdi;
	}
	
	public static synchronized void fareGirdisiYaz(int kod, boolean girdi) {
		girdiYaz(-kod, girdi);
	}
	
	public static synchronized void imleçGirdisiYaz(float x, float y) {
		İMLEÇ_GİRDİSİ.yaz(x, y);
	}
	
	public static synchronized void tekerlekGirdisiYaz(int dönme) {
		tekerlekGirdisi += dönme;
	}
	
	public static synchronized boolean imleçBoştaMı() {
		return imleçHedefi == null;
	}
	
	public static synchronized boolean imleçUygunMu(Object hedef) {
		return imleçBoştaMı() || imleçHedefi == hedef;
	}
	
	public static synchronized void imleçKullanıldı(Object hedef) {
		imleçHedefi = hedef;
	}
	
	public static synchronized void imleçBoşta() {
		imleçKullanıldı(null);
	}
	
	public static synchronized boolean tekerlekBoştaMı() {
		return tekerlekHedefi == null;
	}
	
	public static synchronized boolean tekerlekUygunMu(Object hedef) {
		return tekerlekBoştaMı() || tekerlekHedefi == hedef;
	}
	
	public static synchronized void tekerlekKullanıldı(Object hedef) {
		tekerlekHedefi = hedef;
	}
	
	public static synchronized void tekerlekBoşta() {
		tekerlekKullanıldı(null);
	}
}
