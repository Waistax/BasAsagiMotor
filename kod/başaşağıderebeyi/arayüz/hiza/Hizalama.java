/**
 * başaşağıderebeyi.arayüz.hiza.Hizalama.java
 * 0.16 / 13 Eyl 2020 / 18:12:38
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.hiza;

import başaşağıderebeyi.matematik.*;

import java.util.*;

public class Hizalama {
	public final Dikdörtgen2 alan;
	public final List<Hiza> hizalar;
	
	public Hizalama() {
		alan = new Dikdörtgen2();
		hizalar = new ArrayList<>(4);
	}
	
	public void hesapla(Dikdörtgen2 levha) {
		for (Hiza hiza : hizalar)
			hiza.hesapla(levha);
	}
	
	private Hizalama hizaEkle(Hiza hiza) {
		hiza.hizalama = this;
		hizalar.add(hiza);
		return this;
	}
	
	public Hizalama kx(Hiza hiza) {
		hiza.yön = HizaYönü.KÜÇÜK_YATAY;
		return hizaEkle(hiza);
	}
	
	public Hizalama ky(Hiza hiza) {
		hiza.yön = HizaYönü.KÜÇÜK_DİKEY;
		return hizaEkle(hiza);
	}
	
	public Hizalama bx(Hiza hiza) {
		hiza.yön = HizaYönü.BÜYÜK_YATAY;
		return hizaEkle(hiza);
	}
	
	public Hizalama by(Hiza hiza) {
		hiza.yön = HizaYönü.BÜYÜK_DİKEY;
		return hizaEkle(hiza);
	}
	
	public Hizalama g(Hiza hiza) {
		boolean k = false;
		for (Hiza eskiHiza : hizalar)
			if (eskiHiza.yön == HizaYönü.KÜÇÜK_YATAY) {
				k = true;
				break;
			}
		hiza.yön = k ? HizaYönü.BÜYÜK_YATAY : HizaYönü.KÜÇÜK_YATAY;
		return hizaEkle(hiza);
	}
	
	public Hizalama y(Hiza hiza) {
		boolean k = false;
		for (Hiza eskiHiza : hizalar)
			if (eskiHiza.yön == HizaYönü.KÜÇÜK_DİKEY) {
				k = true;
				break;
			}
		hiza.yön = k ? HizaYönü.BÜYÜK_DİKEY : HizaYönü.KÜÇÜK_DİKEY;
		return hizaEkle(hiza);
	}
	
	public Hizalama o(Hiza hiza) {
		boolean kx = false;
		boolean ky = false;
		boolean bx = false;
		boolean by = false;
		for (Hiza eskiHiza : hizalar)
			if (eskiHiza.yön == HizaYönü.KÜÇÜK_YATAY) {
				kx = true;
			} else if (eskiHiza.yön == HizaYönü.KÜÇÜK_DİKEY) {
				ky = true;
			} else if (eskiHiza.yön == HizaYönü.BÜYÜK_YATAY) {
				bx = true;
			} else if (eskiHiza.yön == HizaYönü.BÜYÜK_DİKEY) {
				by = true;
			}
		if (!kx) {
			hiza.yön = HizaYönü.KÜÇÜK_YATAY;
		} else if (!ky) {
			hiza.yön = HizaYönü.KÜÇÜK_DİKEY;
		} else if (!bx) {
			hiza.yön = HizaYönü.BÜYÜK_YATAY;
		} else if (!by) {
			hiza.yön = HizaYönü.BÜYÜK_DİKEY;
		}
		return hizaEkle(hiza);
	}
}
