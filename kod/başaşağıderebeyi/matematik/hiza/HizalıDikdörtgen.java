/**
 * başaşağıderebeyi.matematik.hiza.HizalıDikdörtgen.java
 * 0.24 / 7 Kas 2020 / 15:28:16
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik.hiza;

import başaşağıderebeyi.matematik.*;

public class HizalıDikdörtgen {
	public final Dikdörtgen ana;
	public final Dikdörtgen hedef;
	public final Hiza[] hizalar;
	
	public boolean bağımsızYatay;
	
	public HizalıDikdörtgen(Dikdörtgen ana, Dikdörtgen hedef) {
		this.ana = ana;
		this.hedef = hedef;
		hizalar = new Hiza[4];
	}
	
	public HizalıDikdörtgen(Dikdörtgen ana) {
		this(ana, new Dikdörtgen());
	}
	
	public void yatayHizala() {
		hizalar[0].hesapla();
		hizalar[1].hesapla();
		hedef.hesaplaYatay(hizalar[0].veri, hizalar[1].veri);
	}
	
	public void dikeyHizala() {
		hizalar[2].hesapla();
		hizalar[3].hesapla();
		hedef.hesaplaDikey(hizalar[2].veri, hizalar[3].veri);
	}
	
	public void hizala() {
		if (bağımsızYatay) {
			yatayHizala();
			dikeyHizala();
		} else {
			dikeyHizala();
			yatayHizala();
		}
	}
	
	public HizalıDikdörtgen ayarla() {
		bağımsızYatay = true;
		for (int i = 0; i < hizalar.length; i++) {
			Hiza hiza = hizalar[i];
			boolean yatay = i < hizalar.length / 2;
			if (yatay && hiza.bağımlı)
				bağımsızYatay = false;
			hiza.ana = ana;
			hiza.hedef = hedef;
			hiza.yön = HizaYönü.yönüAl(hiza.veri, yatay);
			if (hiza.ikincil)
				hiza.birincilYön = hizalar[i - 1].yön;
		}
		return this;
	}
	
	public HizalıDikdörtgen yatay(Hiza hiza) {
		hizalar[(hiza.ikincil || hizalar[0] != null) ? 1 : 0] = hiza;
		return this;
	}
	
	public HizalıDikdörtgen dikey(Hiza hiza) {
		hizalar[(hiza.ikincil || hizalar[2] != null) ? 3 : 2] = hiza;
		return this;
	}
	
	public void hepsiniAyarla(Hiza y1, Hiza y2, Hiza d1, Hiza d2) {
		yatay(y1).yatay(y2).dikey(d1).dikey(d2).ayarla();
	}
}
