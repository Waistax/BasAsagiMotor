/**
 * başaşağıderebeyi.matematik.Dikdörtgen.java
 * 0.13 / 8 Eyl 2020 / 09:37:00
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik;

public class Dikdörtgen {
	public final Vektör2 k;
	public final Vektör2 b;
	public final Vektör2 o;
	public final Vektör2 ö;
	
	public Dikdörtgen() {
		k = new Vektör2();
		b = new Vektör2();
		o = new Vektör2();
		ö = new Vektör2();
	}
	
	public Dikdörtgen(Dikdörtgen d) {
		this();
		yaz(d);
	}
	
	public Dikdörtgen yaz(Dikdörtgen d) {
		k.yaz(d.k);
		b.yaz(d.b);
		o.yaz(d.o);
		ö.yaz(d.ö);
		return this;
	}
	
	public Dikdörtgen yuvarla(Dikdörtgen d) {
		k.yuvarla(d.k);
		b.yuvarla(d.b);
		o.yuvarla(d.o);
		ö.yuvarla(d.ö);
		return this;
	}
	
	public Dikdörtgen yuvarla() {
		return yuvarla(this);
	}
	
	public Dikdörtgen tavan(Dikdörtgen d) {
		k.tavan(d.k);
		b.tavan(d.b);
		o.tavan(d.o);
		ö.tavan(d.ö);
		return this;
	}
	
	public Dikdörtgen tavan() {
		return tavan(this);
	}
	
	public Dikdörtgen taban(Dikdörtgen d) {
		k.taban(d.k);
		b.taban(d.b);
		o.taban(d.o);
		ö.taban(d.ö);
		return this;
	}
	
	public Dikdörtgen taban() {
		return taban(this);
	}
	
	public Dikdörtgen araDeğer(Dikdörtgen sol, Dikdörtgen sağ, float solaUzaklık, float sağaUzaklık) {
		k.araDeğer(sol.k, sağ.k, solaUzaklık, sağaUzaklık);
		b.araDeğer(sol.b, sağ.b, solaUzaklık, sağaUzaklık);
		o.araDeğer(sol.o, sağ.o, solaUzaklık, sağaUzaklık);
		ö.araDeğer(sol.ö, sağ.ö, solaUzaklık, sağaUzaklık);
		return this;
	}
	
	public Dikdörtgen araDeğer(Dikdörtgen d, float uzaklık, float yakınlık) {
		return araDeğer(this, d, uzaklık, yakınlık);
	}
	
	public Dikdörtgen ortala(Dikdörtgen d) {
		k.çıkar(d.o, o);
		o.topla(k);
		b.topla(k);
		k.çıkar(b, ö);
		return this;
	}
	
	public boolean eşittir(Dikdörtgen d) {
		return
				k.eşittir(d.k) &&
				b.eşittir(d.b) &&
				o.eşittir(d.o) &&
				ö.eşittir(d.ö);
	}
	
	public boolean içinde(Vektör2 v) {
		return
				k.x <= v.x &&
				k.y <= v.y &&
				b.x >= v.x &&
				b.y >= v.y;
	}
	
	@SuppressWarnings("incomplete-switch")
	public void hesaplaYatay(DikdörtgenVerisi v1, DikdörtgenVerisi v2) {
		if (v1 == null || v2 == null || v1.ordinal() == v2.ordinal())
			return;
		else if (v1.ordinal() > v2.ordinal()) {
			DikdörtgenVerisi t = v1;
			v1 = v2;
			v2 = t;
		}
		switch (v1) {
		case KÜÇÜK:
			switch (v2) {
			case BÜYÜK:
				o.x = (k.x + b.x) / 2.0F;
				ö.x = b.x - k.x;
				return;
			case ORTA:
				b.x = 2.0F * o.x - k.x;
				ö.x = (o.x - k.x) * 2.0F;
				return;
			case ÖLÇÜ:
				b.x = k.x + ö.x;
				o.x = k.x + ö.x / 2.0F;
				return;
			}
		case BÜYÜK:
			switch (v2) {
			case ORTA:
				k.x = 2.0F * o.x - b.x;
				ö.x = (b.x - o.x) * 2.0F;
				return;
			case ÖLÇÜ:
				k.x = b.x - ö.x;
				o.x = b.x - ö.x / 2.0F;
				return;
			}
		case ORTA:
			k.x = o.x - ö.x / 2.0F;
			b.x = o.x + ö.x / 2.0F;
			return;
		}
	}
	
	@SuppressWarnings("incomplete-switch")
	public void hesaplaDikey(DikdörtgenVerisi v1, DikdörtgenVerisi v2) {
		if (v1 == null || v2 == null || v1 == v2)
			return;
		else if (v1.ordinal() > v2.ordinal()) {
			DikdörtgenVerisi t = v1;
			v1 = v2;
			v2 = t;
		}
		switch (v1) {
		case KÜÇÜK:
			switch (v2) {
			case BÜYÜK:
				o.y = (k.y + b.y) / 2.0F;
				ö.y = b.y - k.y;
				return;
			case ORTA:
				b.y = 2.0F * o.y - k.y;
				ö.y = (o.y - k.y) * 2.0F;
				return;
			case ÖLÇÜ:
				b.y = k.y + ö.y;
				o.y = k.y + ö.y / 2.0F;
				return;
			}
		case BÜYÜK:
			switch (v2) {
			case ORTA:
				k.y = 2.0F * o.y - b.y;
				ö.y = (b.y - o.y) * 2.0F;
				return;
			case ÖLÇÜ:
				k.y = b.y - ö.y;
				o.y = b.y - ö.y / 2.0F;
				return;
			}
		case ORTA:
			k.y = o.y - ö.y / 2.0F;
			b.y = o.y + ö.y / 2.0F;
			return;
		}
	}
	
	public void hesapla(DikdörtgenVerisi y1, DikdörtgenVerisi y2, DikdörtgenVerisi d1, DikdörtgenVerisi d2) {
		hesaplaYatay(y1, y2);
		hesaplaDikey(d1, d2);
	}
	
	@Override
	public boolean equals(Object obj) {
		return eşittir((Dikdörtgen)obj);
	}
	
	@Override
	public String toString() {
		return "[" + k + ", " + b + ", " + o + ", " + ö + "]";
	}
}
