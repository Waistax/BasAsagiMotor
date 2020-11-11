/**
 * başaşağıderebeyi.matematik.hiza.HizaVerisi.java
 * 0.16 / 13 Eyl 2020 / 18:25:40
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik.hiza;

import başaşağıderebeyi.matematik.*;

public enum HizaYönü {
	KÜÇÜK_YATAY(),
	KÜÇÜK_DİKEY(),
	BÜYÜK_YATAY(),
	BÜYÜK_DİKEY(),
	ORTA_YATAY(),
	ORTA_DİKEY(),
	ÖLÇÜ_YATAY(),
	ÖLÇÜ_DİKEY();
	
	public static HizaYönü yönüAl(DikdörtgenVerisi dikdörtgenVerisi, boolean yatay) {
		return values()[dikdörtgenVerisi.ordinal() * 2 + (yatay ? 0 : 1)];
	}
	
	public final DikdörtgenVerisi dikdörtgenVerisi;
	
	private HizaYönü() {
		dikdörtgenVerisi = DikdörtgenVerisi.values()[ordinal() / 2];
	}
	
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
			return this;
		}
	}
	
	public HizaYönü komşu() {
		switch (this) {
		case KÜÇÜK_YATAY:
			return HizaYönü.KÜÇÜK_DİKEY;
		case KÜÇÜK_DİKEY:
			return HizaYönü.KÜÇÜK_YATAY;
		case BÜYÜK_YATAY:
			return HizaYönü.BÜYÜK_DİKEY;
		case BÜYÜK_DİKEY:
			return HizaYönü.BÜYÜK_YATAY;
		case ORTA_YATAY:
			return HizaYönü.ORTA_DİKEY;
		case ORTA_DİKEY:
			return HizaYönü.ORTA_YATAY;
		case ÖLÇÜ_YATAY:
			return HizaYönü.ÖLÇÜ_DİKEY;
		case ÖLÇÜ_DİKEY:
			return HizaYönü.ÖLÇÜ_YATAY;
		default:
			return null;
		}
	}
	
	public HizaYönü küçük() {
		return ordinal() % 2 == 0 ? KÜÇÜK_YATAY : KÜÇÜK_DİKEY;
	}

	public HizaYönü büyük() {
		return ordinal() % 2 == 0 ? BÜYÜK_YATAY : BÜYÜK_DİKEY;
	}
	
	public HizaYönü orta() {
		return ordinal() % 2 == 0 ? ORTA_YATAY : ORTA_DİKEY;
	}
	
	public HizaYönü ölçü() {
		return ordinal() % 2 == 0 ? ÖLÇÜ_YATAY : ÖLÇÜ_DİKEY;
	}
	
	public float al(Dikdörtgen d) {
		switch (this) {
		case KÜÇÜK_YATAY:
			return d.k.x;
		case BÜYÜK_YATAY:
			return d.b.x;
		case KÜÇÜK_DİKEY:
			return d.k.y;
		case BÜYÜK_DİKEY:
			return d.b.y;
		case ORTA_YATAY:
			return d.o.x;
		case ORTA_DİKEY:
			return d.o.y;
		case ÖLÇÜ_YATAY:
			return d.ö.x;
		case ÖLÇÜ_DİKEY:
			return d.ö.y;
		default:
			return 0.0F;
		}
	}
	
	public HizaYönü yaz(Dikdörtgen d, float o) {
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
		case ORTA_YATAY:
			d.o.yazX(o);
			return this;
		case ORTA_DİKEY:
			d.o.yazY(o);
			return this;
		case ÖLÇÜ_YATAY:
			d.ö.yazX(o);
			return this;
		case ÖLÇÜ_DİKEY:
			d.ö.yazY(o);
			return this;
		default:
			return this;
		}
	}
}
