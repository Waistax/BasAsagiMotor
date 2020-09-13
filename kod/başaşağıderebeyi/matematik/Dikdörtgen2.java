/**
 * başaşağıderebeyi.matematik.Dikdörtgen2.java
 * 0.13 / 8 Eyl 2020 / 09:37:00
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik;

public class Dikdörtgen2 {
	public final Vektör2 k;
	public final Vektör2 b;
	
	public Dikdörtgen2() {
		k = new Vektör2();
		b = new Vektör2();
	}
	
	public Dikdörtgen2(float kx, float ky, float bx, float by) {
		this();
		yaz(kx, ky, bx, by);
	}
	
	public Dikdörtgen2(Vektör2 k, Vektör2 b) {
		this();
		yaz(k, b);
	}
	
	public Dikdörtgen2(Dikdörtgen2 d) {
		this();
		yaz(d);
	}
	
	public Dikdörtgen2 yaz(float kx, float ky, float bx, float by) {
		k.yaz(kx, ky);
		b.yaz(bx, by);
		return this;
	}
	
	public Dikdörtgen2 yaz(Vektör2 k, Vektör2 b) {
		return yaz(k.x, k.y, b.x, b.y);
	}
	
	public Dikdörtgen2 yaz(Dikdörtgen2 d) {
		return yaz(d.k, d.b);
	}
	
	public Dikdörtgen2 yuvarla(Dikdörtgen2 d) {
		k.yuvarla(d.k);
		b.yuvarla(d.b);
		return this;
	}
	
	public Dikdörtgen2 yuvarla() {
		return yuvarla(this);
	}
	
	public Dikdörtgen2 tavan(Dikdörtgen2 d) {
		k.tavan(d.k);
		b.tavan(d.b);
		return this;
	}
	
	public Dikdörtgen2 tavan() {
		return tavan(this);
	}
	
	public Dikdörtgen2 taban(Dikdörtgen2 d) {
		k.taban(d.k);
		b.taban(d.b);
		return this;
	}
	
	public Dikdörtgen2 taban() {
		return taban(this);
	}
	
	public Dikdörtgen2 araDeğer(Dikdörtgen2 sol, Dikdörtgen2 sağ, float solaUzaklık, float sağaUzaklık) {
		k.araDeğer(sol.k, sağ.k, solaUzaklık, sağaUzaklık);
		b.araDeğer(sol.b, sağ.b, solaUzaklık, sağaUzaklık);
		return this;
	}
	
	public Dikdörtgen2 araDeğer(Dikdörtgen2 d, float uzaklık, float yakınlık) {
		return araDeğer(this, d, uzaklık, yakınlık);
	}
	
	public boolean eşittir(float kx, float ky, float bx, float by) {
		return k.eşittir(kx, ky) && b.eşittir(bx, by);
	}
	
	public boolean eşittir(Vektör2 k, Vektör2 b) {
		return eşittir(k.x, k.y, b.x, b.y);
	}
	
	public boolean eşittir(Dikdörtgen2 d) {
		return eşittir(d.k, d.b);
	}
	
	public boolean içinde(Vektör2 v) {
		return k.x <= v.x && k.y <= v.y && b.x >= v.x && b.y >= v.y;
	}
	
	@Override
	public boolean equals(Object obj) {
		return eşittir((Dikdörtgen2)obj);
	}
	
	@Override
	public String toString() {
		return "[" + k + ", " + b + "]";
	}
}
