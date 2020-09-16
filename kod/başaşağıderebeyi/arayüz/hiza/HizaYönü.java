/**
 * başaşağıderebeyi.arayüz.hiza.HizaYönü.java
 * 0.16 / 13 Eyl 2020 / 18:25:40
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.hiza;

import başaşağıderebeyi.matematik.*;

public enum HizaYönü {
	KÜÇÜK_YATAY, KÜÇÜK_DİKEY, BÜYÜK_YATAY, BÜYÜK_DİKEY;
	
	public HizaYönü karşı() {
		switch (this) {
		case KÜÇÜK_YATAY:
			return HizaYönü.BÜYÜK_YATAY;
		case KÜÇÜK_DİKEY:
			return HizaYönü.BÜYÜK_DİKEY;
		case BÜYÜK_YATAY:
			return HizaYönü.KÜÇÜK_YATAY;
		case BÜYÜK_DİKEY:
			return HizaYönü.KÜÇÜK_DİKEY;
		default:
			return null;
		}
	}
	
	public HizaYönü ters() {
		switch (this) {
		case KÜÇÜK_YATAY:
			return HizaYönü.KÜÇÜK_DİKEY;
		case KÜÇÜK_DİKEY:
			return HizaYönü.KÜÇÜK_YATAY;
		case BÜYÜK_YATAY:
			return HizaYönü.BÜYÜK_DİKEY;
		case BÜYÜK_DİKEY:
			return HizaYönü.BÜYÜK_YATAY;
		default:
			return null;
		}
	}
	
	public float al(Vektör2 v) {
		switch (this) {
		case KÜÇÜK_YATAY, BÜYÜK_YATAY:
			return v.x;
		case KÜÇÜK_DİKEY, BÜYÜK_DİKEY:
			return v.y;
		default:
			return 0.0F;
		}
	}
	
	public HizaYönü yaz(Vektör2 v, float o) {
		switch (this) {
		case KÜÇÜK_YATAY, BÜYÜK_YATAY:
			v.yazX(o);
			return this;
		case KÜÇÜK_DİKEY, BÜYÜK_DİKEY:
			v.yazY(o);
			return this;
		default:
			return this;
		}
	}
	
	public float al(Dikdörtgen2 d) {
		switch (this) {
		case KÜÇÜK_YATAY:
			return d.k.x;
		case BÜYÜK_YATAY:
			return d.b.x;
		case KÜÇÜK_DİKEY:
			return d.k.y;
		case BÜYÜK_DİKEY:
			return d.b.y;
		default:
			return 0.0F;
		}
	}
	
	public HizaYönü yaz(Dikdörtgen2 d, float o) {
		switch (this) {
		case KÜÇÜK_YATAY:
			d.k.yazX(o);
			return this;
		case BÜYÜK_YATAY:
			d.b.yazX(o);
			return this;
		case KÜÇÜK_DİKEY:
			d.k.yazY(o);
			return this;
		case BÜYÜK_DİKEY:
			d.b.yazY(o);
			return this;
		default:
			return this;
		}
	}
	
	public float boyut(Dikdörtgen2 d) {
		switch (this) {
		case KÜÇÜK_YATAY, BÜYÜK_YATAY:
			return d.genişlik();
		case KÜÇÜK_DİKEY, BÜYÜK_DİKEY:
			return d.yükseklik();
		default:
			return 0.0F;
		}
	}
	
	public HizaYönü boyutYaz(Dikdörtgen2 d, float o) {
		switch (this) {
		case KÜÇÜK_YATAY:
			d.k.yazX(d.b.x - o);
			return this;
		case BÜYÜK_YATAY:
			d.b.yazX(d.k.x + o);
			return this;
		case KÜÇÜK_DİKEY:
			d.k.yazY(d.b.y - o);
			return this;
		case BÜYÜK_DİKEY:
			d.b.yazY(d.k.y + o);
			return this;
		default:
			return this;
		}
	}
	
	public float kenarToplam(Dikdörtgen2 d) {
		switch (this) {
		case KÜÇÜK_YATAY, BÜYÜK_YATAY:
			return d.yatayToplam();
		case KÜÇÜK_DİKEY, BÜYÜK_DİKEY:
			return d.dikeyToplam();
		default:
			return 0.0F;
		}
	}
}
